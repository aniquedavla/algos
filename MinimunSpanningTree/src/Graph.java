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

    public void addNeighbor(int v1, int v2, int weight) {
        adjMap.get(v1).add(v2);
        adjacencyList[v1].add(new Edge(v1, v2,weight));
        adjacencyList[v2].add(new Edge(v1, v2,weight));
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
    public void printGraph(){
        for(int i = 0; i < this.numbV; i++){
            printLinkedList2(i, adjacencyList[i]);
            System.out.println();
        }
    }
    private void printLinkedList2(int i, LinkedList<Edge> list) {
        System.out.print("Vertex -> " +i + " : ");
        Iterator<Edge> iter = list.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next().dest+ " | ");
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