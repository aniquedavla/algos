import com.sun.javafx.geom.Edge;

/**
 * Created by aniquedavla on 12/21/16.
 */
public class Test {
    public static void main(String[] args){
        UndirectedGraph aAdjListofUndirectedGraph = new UndirectedGraph("tinyEWG.txt");
        Graph undirectedGraph = aAdjListofUndirectedGraph.makeUndirectedGraph();
        MST_Prims primsMST = new MST_Prims();
        Collection<Edge<Integer>> edges = primsMST.solvePrim();
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }

    }
}
