import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by aniquedavla on 12/21/16.
 */
public class AdjListG {
    private String fileName;

    //intialize undirectedGraph and return a undirectured graph.
    public AdjListG(String fileName) {
        this.fileName = fileName;
    }

    //takes a file of adj list and return an undirected graph.
    public Graph makeUndirectedGraph(){
        //read the file of adjaceny list.
        Graph graph = null;
        try {
            FileReader file = new FileReader(fileName);
            BufferedReader br = new BufferedReader(file);
            int size = Integer.parseInt(br.readLine());
            graph = new Graph(size);

            String line = br.readLine();


            while (line != null) {
                //read nodes
                String[] nodeVal = line.split(" ");
                int[] nodesList = new int[nodeVal.length];
                for (int i = 0; i < nodesList.length; ++i) {
                    nodesList[i] = Integer.parseInt(nodeVal[i]);
                }

                //read edges
                while((line = br.readLine()) != null) {
                    String[] tokens = line.split(" ");
                    int v1 = Integer.parseInt(tokens[0]);
                    int v2 = Integer.parseInt(tokens[1]);
                    int weight = Integer.parseInt(tokens[2]);

                    //we add neighbor to each node in both directions.
                    graph.addNeighbor(v1, v2,weight);
                }

            }
            br.close();
        }
        catch(Exception theEx) {
            theEx.printStackTrace();
        }
        return graph;
    }
}
