import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aniquedavla on 12/21/16.
 */

//a combinatinon of heap and map, supports extact min, decreaseKey, extracMin, and others.
public class HeapMap {

    private List<Node> heap = new ArrayList<Node>();
    private Map<Integer, Integer> position = new HashMap<Integer, Integer>();

    public boolean contains(int key){
        return position.containsKey(key);
    }
    public int getWeight(int key){
        return heap.get(position.get(key)).weight;
    }
    public boolean isEmpty(){
        return heap.size() == 0 ? true : false;
    }

    public int getParent(int i){
        if(i == 0 || i >= this.heap.size()) return -1;
        else return (i-1)/2;
    }

    public int getLeftChild(int i){
        int leftChild = (i * 2) + 1;
        if(leftChild >= heap.size()) return -1;
        return leftChild;
    }
    public int getRightChild(int i){
        int rightChild = (i * 2) + 2;
        if(rightChild >= heap.size()) return -1;
        return rightChild;
    }

    public Node getMinimum(){
        return heap.get(0);
    }

    public void min_heapify(int index){
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);
        int smallest = index;
        if(leftChild != -1 && heap.get(leftChild).weight < heap.get(smallest).weight) smallest = leftChild;
        if(rightChild != -1 && heap.get(rightChild).weight < heap.get(smallest).weight) smallest = rightChild;
        if(smallest != index){
            swap(smallest, index);
            min_heapify(smallest);
        }

    }
    public void swap(int loc1, int loc2) {
        // TODO Auto-generated method stub
        int temp = heap.get(loc1).key;
        heap.get(loc1).key = heap.get(loc2).key;
        heap.get(loc2).key = temp;

        temp = heap.get(loc1).weight;
        heap.get(loc1).weight = heap.get(loc2).weight;
        heap.get(loc2).weight = temp;

        position.put(heap.get(loc1).key, loc1);
        position.put(heap.get(loc2).key, loc2);
    }

    public void insertItem(int key, int weight){
        heap.add(new Node(key, weight));

        int i = heap.size() - 1;
        position.put(key, i);
        while(i > 0 && heap.get(i).weight < heap.get(getParent(i)).weight){
            swap(i, getParent(i));
            i = getParent(i);
        }
    }
    //Increase Key operation of min heap map is same as heapify at the index
    public void decreaseKey(int key, int newValue){
        if(!this.contains(key)) {
            System.out.println("Key not present !!");
            return;
        }

        int i = position.get(key);
        heap.get(i).weight = newValue;
        while(i > 0 && heap.get(i).weight < heap.get(getParent(i)).weight){
            swap(i, getParent(i));
            i = getParent(i);
        }
    }
    public Node extractMinimum(){
        Node minNode = new Node(heap.get(0).key, heap.get(0).weight);
        Node lastNode = heap.remove(heap.size() - 1);

        position.remove(minNode.key);

        if(heap.size() == 0) return minNode;

        heap.get(0).key = lastNode.key;
        heap.get(0).weight = lastNode.weight;
        position.put(lastNode.key, 0);

        min_heapify(0);
        return minNode;
    }
    public void printHeap(){
        for(Node node : heap){
            System.out.println("Key : "+ node.key + " Weight : "+ node.weight);
        }
    }
    public static void main(String[] args) {
        int[] keys =    {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int[] weight = {10, 5, 7, 2, 6, 12, 8, 22, 4};

        HeapMap heapMap = new HeapMap();
        for(int i = 0; i < keys.length; i++){
            heapMap.insertItem(keys[i], weight[i]);
        }

        heapMap.extractMinimum();

        heapMap.decreaseKey(4, 1);

        heapMap.printHeap();
        Set<Integer> set = heapMap.position.keySet();
        for(Integer key : set){
            System.out.println("Position : (Key) "+ key + " : (Position)" + heapMap.position.get(key));
        }
    }
}