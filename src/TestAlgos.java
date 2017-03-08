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

        //test binary search
        int[] sortedA={1,2,3,4,5};
        System.out.println(Util.binarySearchIterative(sortedA,4));
        System.out.println(Util.binarySearchRecursive(sortedA,4,0,sortedA.length-1));

    }
}
