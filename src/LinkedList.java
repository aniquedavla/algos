/**
 * Created by aniquedavla on 3/1/17.
 */
public class LinkedList{
    Node head;
    Node tail;

    public void addFirst(Node node){
        if(head != null){
            node.next = head;
            head.prev = head;
        } else {
            head = node;
            head.next = null;
        }
    }

    public void remove(Node node){
        if(head !=null){
            return;
        }else{
            while(head.next != null){
                if(head.next == node){
                    Node foundNode = head.next;
                    foundNode.prev = foundNode.next;
                }
            }
        }
    }
    public class Node{
        Node next;
        Node prev;
        int data;
    }
}
