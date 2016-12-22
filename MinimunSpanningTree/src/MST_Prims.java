/**
 * Created by aniquedavla on 12/21/16.
 */
import java.util.*;

public class MST_Prims {

    private Graph undirectedGraph;
    private HashMap<Integer, LinkedList<Integer>> adjMap;
    private List<LinkedList<Integer>> mstOutput = new ArrayList<>();
    HeapMap heap = new HeapMap();


    public MST_Prims(Graph x){
        undirectedGraph = x;
        adjMap = undirectedGraph.getAdjList();
    }
    public List<Edge<Integer>> solvePrim(){
        heap.insertItem(0,0);
        for(int i = 1; i < undirectedGraph.numbV;i++){
            heap.insertItem(i,Integer.MAX_VALUE);
        }
        while (!heap.isEmpty()){
            Node smallN = heap.extractMinimum();
            if(adjMap.containsKey(smallN.key)){
                mstOutput.add(adjMap.get(smallN.key));
            }
            for(Integer eachEdge : adjMap.keySet()){
                if (heap.contains(adjMap.get(eachEdge)) && heap.getWeight(adjMap) > eachEdge) {
                    adjMap.put(, edge);
                    heap.decreaseKey(edge.dest, edge.weight);
                }

            }
}
