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

    //bugy
    public void remove(Node node){
        if(head ==null){
            return;
        }else if(node.data == head.data){
            head.next.prev = node;
            node.next = head.next;
            node.prev = null;
            head = node;
            System.gc();
        } else if(tail.data == node.data){
            tail.prev.next  = node;
            node.next = null;
            tail = node;
            System.gc();
        }else{
            Node currentNode = head;
            while(currentNode.data != node.data) {
                currentNode = head.next;
            }
            if(currentNode.data == node.data){
                Node foundNode = currentNode;
                foundNode.prev.next =currentNode.next;
                foundNode.next.prev = currentNode.prev;
            }
        }
    }
    //Flyod's algorithm
    // returns the Node where the cycle is detected, null if no cycle.
    /*
    while head.next !null && head.next.next !null
        slow head
    */
    public Node isCycle(){
        if(head == null || head.next == null){
            return null;
        }
        Node fast = head;
        Node slow = head;
        while(fast !=null){
            if(fast == slow){
                return fast;
            }
            else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return null;
    }

    public void printList(){
        Node currentNode = head;
        if(currentNode != null){
            while(currentNode != null){
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        } else System.out.println("Empty LinkedList");
    }
}
