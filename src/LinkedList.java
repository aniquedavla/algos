/**
 * Created by aniquedavla on 3/1/17.
 */
public class LinkedList{
    Node head;
    Node tail;

    public LinkedList(Node head, Node tail){
        this.head = head;
        this.tail = tail;
    }

    public void addFirst(Node node){
        if(head != null){
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        } else {
            head = node;
            tail = node;
            head.prev = node;
            head.next = null;

        }
    }

    public void removeHead(Node node){
        if(head !=null){
            return;
        }else{
            while(head.next != null){
                if(head.next == node){
                    Node foundNode = head.next;
                    foundNode.prev = foundNode.next;
                    foundNode.next.prev = foundNode.prev;
                }
            }
        }
    }

    public void printList(){
        Node currentNode = this.head;
        if(currentNode != null){
            while(currentNode != null){
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        } else System.out.println("Empty LinkedList");
    }
}
