import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FileCompressor {
    
    public static final int Q = 256;
    
    private static final String FILE_EXTENSION = ".compd";
    
    /**
     * Decompresses the file specified
     * @param filename Name of the file
     * @param destination File extension of destination file
     * @throws IOException
     */
    public void decompress(String filename, String destination) throws IOException {
        // Read array of bytes from the file to decompress
        byte[] byteArray;
        try {
            byteArray = CompressionUtils.readBytesFromFile(filename);
        } catch (FileNotFoundException e) {
            System.out.println(filename + ": file not found!");
            return;
        }
        
        // The frequency array is stored at the start of the file, so we have go retrieve this
        // The array is 1kB (1024 bytes)
        System.out.println("Fetching frequency array...");
        int[] freqArray = CompressionUtils.getFrequencyFromArray(byteArray);
        
        // Create a new array for storing the actual data
        byte[] data = CompressionUtils.getDataFromArray(byteArray);
        
        // Use the frequency array to find the original size of the file
        // Original size = sum of the frequency array
        int originalSize = 0;
        for (int i = 0; i < freqArray.length; i++) {
            originalSize += freqArray[i];
        }
        System.out.println("Original file size: " + originalSize);
        
        System.out.println("Decompressing file...");
        
        // Build a huffman tree out of the frequency array
        System.out.println("Building huffman tree...");
        Tree t = CompressionUtils.buildHuffmanTree(freqArray);
        
        // Using the huffman tree, we can construct an array of the original data
        System.out.println("Building bit string...");
        String bitString = toBinary(data);      // Get a bit string of the data
        System.out.println("Reconstructing original data...");
        byte[] originalData = t.getByte(bitString, originalSize);
        
        // Then we can write the data back to a new file
        System.out.println("Writing to file...");
        try (FileOutputStream fos = new FileOutputStream(destination)) {
            fos.write(originalData);
            fos.close();
        } catch(Exception e) {
            System.out.println("Error while writing to file.");
            e.printStackTrace();
            return;
        }
        
        System.out.println("Decompression complete! Created file: " + destination);
    }
    
    private String toBinary(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        
        return sb.toString();
    }
    
    /**
     * Compresses the file specified
     * @param filename Name of the file
     */
    public void compress(String filename) throws IOException {
        // Read byte array from file
        byte[] byteArray;
        try {
            byteArray = CompressionUtils.readBytesFromFile(filename);
        } catch (FileNotFoundException e) {
            System.out.println(filename + ": File not found!");
            return;
        }
        
        // Generate a frequence array out of the byte array
        System.out.println("Creating frequency array...");
        int[] freqArray = CompressionUtils.buildFrequencyArray(byteArray);
        
        System.out.println("Compressing file...");
        // Create a huffman tree out of the frequency array
        Tree t = CompressionUtils.buildHuffmanTree(freqArray);
        
        // Create a string array and fill it with records of bytes with a matching bit string code
        System.out.println("Building bit code lookup table...");
        String[] bitArray = new String[Q];
        Tree.getBitCode(bitArray, t.root, "");
        
        // Go through the byte array from the file, and for each byte find the respective bit code that we generated above
        // Build a string that contains the sequence of bit codes
        System.out.println("Building bit string...");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            String code = bitArray[byteArray[i]+128];
            for (int j = 0; code != null && j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    sb.append("0");
                }
                else if (code.charAt(j) == '1') {
                    sb.append("1");
                }
                else throw new IllegalStateException("Illegal state");
            }
        }
        String bitString = sb.toString();
        
        System.out.println("New size: " + bitString.length() + " bits");
        
        // Go through the bit string, and build a compact byte array that can be stored
        System.out.println("Building compressed byte array...");
        int length = (int)Math.ceil((double)bitString.length() / 8);
        byte[] data = new byte[length];
        for (int i = 0; i < length; i++) {
            int endIndex = ((i + 1) * 8 < bitString.length()) ? (i + 1) * 8 : bitString.length();
            byte b = (byte)Integer.parseInt(bitString.substring(i * 8, endIndex), 2);
            data[i] = b;
        }
        
        // Convert the frequency array to a byte array so that we can use the first kiloByte of the file to 
        // store the frequency array
        System.out.println("Converting frequency array...");
        ByteBuffer byteBuffer = ByteBuffer.allocate(freqArray.length * 4);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(freqArray);
        
        // Write the data to file
        System.out.println("Writing to file...");
        String compressedFilename = filename.substring(0, filename.lastIndexOf('.')) + FILE_EXTENSION;
        try (FileOutputStream fos = new FileOutputStream(compressedFilename)) {
            fos.write(byteBuffer.array());
            fos.write(data);
        } catch (Exception e) {
            System.out.println("Error while reading to file.");
            e.printStackTrace();
            return;
        }
        
        System.out.println("Compression complete! Created file: " + compressedFilename);
    }
    
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        try {
            boolean decompress = false;
            String filename = "";
            String destination = "";
            if (args[0].equals("-d")) {
                decompress = true;
                filename = args[1];
                destination = args[2];
            } else {
                filename = args[0];
            }
            if (filename.equals("")) {
                throw new IllegalArgumentException("File name must be specified!");
            }
            if (decompress && destination.equals("")) {
                throw new IllegalArgumentException("Filename for compressed file must be specified!");
            }
            
            FileCompressor fc = new FileCompressor();
            if (!decompress) {
                fc.compress(filename);
            } else {
                System.out.println(filename.substring(filename.lastIndexOf(".")));
                if (filename.substring(filename.lastIndexOf(".")).equals(FILE_EXTENSION)) {
                    fc.decompress(filename, destination);
                } else {
                    throw new IllegalArgumentException("File format is not supported!");
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}