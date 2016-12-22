import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by aniquedavla on 12/21/16.
 */
public class Graph {
    //adjacency lists for each node
    HashMap<Integer, LinkedList<Integer>> adjList;

    public Graph(int[] nodesList) {
        //your node labels are consecutive integers starting with one.
        //to make the indexing easier we will allocate an array of adjacency one element larger than necessary
        adjList = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < nodesList.length; ++i) {
            adjList.put(i, new LinkedList<Integer>());
        }
    }

    public void addNeighbor(int v1, int v2) {
        adjList.get(v1).add(v2);
    }

    public List<Integer> getNeighbors(int v) {
        return adjList.get(v);
    }

}