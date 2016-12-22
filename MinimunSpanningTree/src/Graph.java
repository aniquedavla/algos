import java.util.*;

/**
 * Created by aniquedavla on 12/21/16.
 */
public class Graph {
    //adjacency lists for each node
    public LinkedList<Edge> adjacencyList[];
    //List<Edge> result = new ArrayList<PrimsAlgorithm.Edge>();

    public int numbV; // number of vertices

    public Graph(int size) {
        //your node labels are consecutive integers starting with one.
        //to make the indexing easier we will allocate an array of adjacency one element larger than necessary
        adjacencyList = new LinkedList[size];
        for (int i = 0; i < size; ++i) {
            adjacencyList[i] = new LinkedList<Edge>();
        }
        this.numbV = size;

    }

    public void addNeighbor(int v1, int v2, int weight) {
        adjacencyList[v1].add(new Edge(v1, v2,weight));
        adjacencyList[v2].add(new Edge(v1, v2,weight));
    }

    public void printGraph(){
        for(int i = 0; i < this.numbV; i++){
            printLinkedList2(i, adjacencyList[i]);
            System.out.println();
        }
    }
    private void printLinkedList2(int i, LinkedList<Edge> list) {
        System.out.print(" V -> " +i + " : ");
        Iterator<Edge> iter = list.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next().dest+ " ");
        }
    }
}