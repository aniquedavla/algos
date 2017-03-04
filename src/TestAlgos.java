/**
 * Created by aniquedavla on 3/3/17.
 */
public class TestAlgos {
    public static void main(String[] args){
        Node head = new Node(5);
        LinkedList list = new LinkedList(head,head);
        list.addFirst(new Node(10));
        list.addFirst(new Node(15));
        list.printList();
    }
}
