import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GraphUtils {

    public static Graph loadGraphFromFile(String filePath) throws IOException {
        Graph result;
        String graphFile = readFile(filePath);

        String[] fileLines = graphFile.split("\n");
        int nodeCount = Integer.parseInt(fileLines[0].trim().split("\\s+", 2)[0]);
        result = new Graph(nodeCount);
        for (int i = 1; i < fileLines.length; i++) {
            int start = Integer.parseInt(fileLines[i].trim().split("\\s+", 2)[0]);
            int dest = Integer.parseInt(fileLines[i].trim().split("\\s+", 2)[1]);
            result.addEdge(start, dest);
        }

        return result;
    }
    
    private static String readFile(String filePath) throws IOException {
        String result = "";
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = "";
        while((line = br.readLine()) != null) {
            result += line + "\n";
        }

        return result;
    }
}