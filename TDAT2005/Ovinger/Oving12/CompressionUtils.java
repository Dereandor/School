import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class CompressionUtils {

    private static final int FREQ_ARRAY_SIZE = 1024;

    /**
     * Returns a frequence array from a byte array read from a file
     * @param byteArray Byte array from file
     * @return Int array of frequencies
     */
    public static int[] getFrequencyFromArray(byte[] byteArray) {
        byte[] newArray = new byte[FREQ_ARRAY_SIZE];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = byteArray[i];
        }

        IntBuffer intBuf = ByteBuffer.wrap(newArray).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        int[] array = new int[intBuf.remaining()];
        intBuf.get(array);

        return array;
    }

    /**
     * Generates a new frequency array from a byte array
     * @param byteArray Byte array to generate from
     * @return Int array of frequencies
     */
    public static int[] buildFrequencyArray(byte[] byteArray) {
        int[] freqArray = new int[256];

        for (int i = 0; i < byteArray.length; i++) {
            freqArray[byteArray[i] + 128]++;
        }

        return freqArray;
    }

    /**
     * Gets data from a byte array read from file (everything past the first kiloByte)
     * @param byteArray Array read from file
     * @return Byte array of data
     */
    public static byte[] getDataFromArray(byte[] byteArray) {
        byte[] data = new byte[byteArray.length - FREQ_ARRAY_SIZE];
        for (int i = 0; i < data.length; i++) {
            data[i] = byteArray[i + FREQ_ARRAY_SIZE];
        }

        return data;
    }

    /**
     * Builds a huffman tree from a frequency array, using the huffman coding method
     * @param frequencyArray Array of byte frequencies
     * @return A tree in huffman form
     */
    public static Tree buildHuffmanTree(int[] frequencyArray) {
        // Create a queue for the huffman
        // Note that the Tree class uses comparable to be ordered by frequency, descending (least first out)
        PriorityQueue<Tree> queue = new PriorityQueue<Tree>();

        // Iterate through frequency and add to queue
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                Tree t = new Tree();
                t.add(new Node(frequencyArray[i], (byte)(i-128)));
                queue.add(t);
            }
        }


        while (queue.size() > 1) {
            Node left = queue.poll().root;
            Node right = queue.poll().root;
            Node root = new Node(left.freq + right.freq);
            root.left = left;
            root.right = right;
            Tree t = new Tree();
            t.root = root;
            queue.add(t);
        }

        return queue.poll();
    }

    /**
     * Reads an array of bytes from the specified file
     * @param filename Name of the file
     * @return Byte array of data
     * @throws IOException
     */
    public static byte[] readBytesFromFile(String filename) throws IOException {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
        int length = dis.available();
        byte[] byteArray = new byte[length];

        dis.readFully(byteArray);

        dis.close();

        return byteArray;
    }
}