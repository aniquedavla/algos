/**
 * Created by aniquedavla on 12/21/16.
 */

import java.util.*;

public class MST_Prims {

    private Graph undirectedGraph;
    private List<Edge> resultList = new ArrayList<Edge>();
    HeapMap heap = new HeapMap();
    Map<Integer, Edge> mstOutput = new HashMap<Integer, Edge>();

    public MST_Prims(Graph x) {
        undirectedGraph = x;
    }

    public void solvePrim() {
        heap.insertItem(0, 0);
        for (int i = 1; i < undirectedGraph.numbV; i++) {
            heap.insertItem(i, Integer.MAX_VALUE);
        }

        while (!heap.isEmpty()) {
            Node smallN = heap.extractMinimum();

            if (mstOutput.containsKey(smallN.key)) {
                resultList.add(mstOutput.get(smallN.key));
            }

            for (Edge edge : undirectedGraph.adjacencyList[smallN.key]) {
                if (heap.contains(edge.dest) && heap.getWeight(edge.dest) > edge.weight) {
                    mstOutput.put(edge.dest, edge);
                    heap.decreaseKey(edge.dest, edge.weight);
                }
            }
        }
    }
    public List<Edge> getMSTResult(){
        return resultList;
    }
}