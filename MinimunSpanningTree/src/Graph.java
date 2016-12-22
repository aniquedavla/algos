import java.util.*;

/**
 * Created by aniquedavla on 12/21/16.
 */
public class Graph {
    //adjacency lists for each node
    HashMap<Integer, LinkedList<Integer>> adjMap;
    public LinkedList<Edge> adjacencyList[];
    //List<Edge> result = new ArrayList<PrimsAlgorithm.Edge>();

    public int numbV; // number of vertices

    public Graph(int[] nodesList) {
        //your node labels are consecutive integers starting with one.
        //to make the indexing easier we will allocate an array of adjacency one element larger than necessary
        adjMap = new HashMap<Integer, LinkedList<Integer>>();
        adjacencyList = new LinkedList[nodesList.length];
        for (int i = 0; i < nodesList.length; ++i) {
            adjMap.put(i, new LinkedList<Integer>());
            adjacencyList[i] = new LinkedList<Edge>();
        }
        this.numbV = nodesList.length;

    }

    public void addNeighbor(int v1, int v2) {
        adjMap.get(v1).add(v2);
    }

    public List<Integer> getNeighbors(int v) {
        return adjMap.get(v);
    }

    public void print(Graph theGraph){

        for(int i = 0; i < theGraph.numbV; i++){
            printLinkedList(i, adjMap);
            System.out.println();
        }
    }
    public HashMap<Integer, LinkedList<Integer>> getAdjList() {
        return adjMap;
    }
    private void printLinkedList(int i, HashMap<Integer, LinkedList<Integer>> list) {
        System.out.print("Vertex -> " +i + " : ");
        Iterator iter = list.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry)iter.next();
            System.out.print(pair.getValue()+ " | ");
        }
    }
}