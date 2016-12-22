/**
 * Created by aniquedavla on 12/21/16.
 *//**
 * Driver
 * \main() method instantiates Maze and MazeSolver types
 *    then solves the maze and outputs the result.
 *
 */
import static org.junit.Assert.*;

public class Test {

    @org.junit.Test
    public void testAllFiles() {
        System.out.println("\n\n------- Prims'MST -------");
        testFile("test1.txt");
        System.out.println();
        testFile("tinyEWG.txt");
        System.out.println();
        testFile("mediumEWG.txt");
    }

    void testFile(String fileName){
        System.out.print("Adjacency List of file: "+fileName+"\n");
        AdjListG aAdjListofUndirectedGraph = new AdjListG(fileName);
        Graph undirectedGraph = aAdjListofUndirectedGraph.makeUndirectedGraph();
        MST_Prims primsMST = new MST_Prims(undirectedGraph);
        undirectedGraph.printGraph();
        primsMST.solvePrim();
        System.out.println();
        System.out.println("===== Solved MST =====");
        System.out.println("Edges:   Weight");

        for(Edge edge : primsMST.getMSTResult()){
            System.out.println("("+edge.src + " to "+edge.dest + ")" + " -> "+ edge.weight);
        }

    }
}

