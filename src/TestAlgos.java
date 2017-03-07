/**
 * Created by aniquedavla on 3/3/17.
 */
public class TestAlgos {
    public static void main(String[] args){
        Node head = new Node(5);
        LinkedList list = new LinkedList(head,head);
        Node node1= new Node(10);
        Node node2= new Node(15);
        Node node3= new Node(25);
        list.addFirst(node1);
        list.addFirst(node2);
        list.addFirst(node3);
        list.remove(head);
        list.printList();
        System.out.println(Strings.reverseString("Anique"));
    }
    public boolean binarySearchRecursive(int[] number, int numberToFind, int leftI, int rightI){
        //protects int overflow by rouding up for large leftI and rightI
        int midI = (leftI + (rightI - leftI)) / 2;
        if
        if(number[numberToFind] < number[midI]){
            binarySearchRecursive(number,numberToFind,leftI,midI-1);
        }else{
            binarySearchRecursive(number,numberToFind,midI+1,rightI);
        }

    }

    public boolean binarySearchIterative(int[] array, int value){
        int low = 0;
        int high =  array.length - 1;
        while(low < high){
            int mid = (high - low)/2;
            if(value == array[mid]){
                return true;
            } else if(value < mid){
                high = mid -1;
            } else if(value > mid){
                low = mid +1;
            }
        }
        return false;
    }
}
