import java.util.List;

/**
 * Created by aniquedavla on 12/21/16.
 */
public class Test {
    public static void main(String[] args){
        UndirectedGraph aAdjListofUndirectedGraph = new UndirectedGraph("test1.txt");
        Graph undirectedGraph = aAdjListofUndirectedGraph.makeUndirectedGraph();
        MST_Prims primsMST = new MST_Prims(undirectedGraph);
        undirectedGraph.printGraph();
        primsMST.solvePrim();
        System.out.println(primsMST.getMSTResult());
        for(Edge edge : primsMST.getMSTResult()){
            System.out.println("("+edge.src + " , "+edge.dest + ")" + " -> "+ edge.weight);
        }



    }
}
