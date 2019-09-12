import java.io.FileNotFoundException;

public class ReadJavaFile {
    public static void main(String [] args) throws FileNotFoundException{
        ReadFilePushStack rfps = new ReadFilePushStack();
        rfps.scanFile(100);
    }
}
