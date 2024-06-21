import java.util.Scanner;
import java.util.LinkedList;
 class Node{
    int val;
    Node next;
    public Node(int v){
        this.val = v;
        this.next = null;
    }
    public Node insertAtstart(Node head, int v){
        Node start = new Node(v);
        start.next = head;
        return start;
    }
    public Node mergeTwoLists(Node list1, Node list2) {
        
        if(list1 == null && list2 == null)
             return null;
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        
                
        Node head = new Node(0);
        Node curr = head;
        
        
        while(list1 != null && list2!= null){
            if(list1.val < list2.val ){
                curr.next = new Node(list1.val);
                list1 = list1.next;
                curr = curr.next;
            }else if(list2.val < list1.val){
                curr.next = new Node(list2.val);
                curr = curr.next;
                list2 = list2.next;
            }else{
                curr.next = new Node(list1.val);
                curr.next.next = new Node(list2.val);
                curr = curr.next.next;
                list1 = list1.next;
                list2 = list2.next;
            }
           
        }
        
        return head.next;
    }
    public Node insertAtend(Node head, int v){
        Node end = new Node(v);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = end;
        return end;
    }
    Node insertAtindex(Node head, int pos, int v){
        Node k = new Node(v);
        Node temp = head;
        for(int i=1; i<pos;i++){
            temp = temp.next;
        }
        k.next = temp.next;
        temp.next = k;
        return head;
    }
    public void print(){
        Node temp = new Node(this.val);
        temp.next = this.next;
        while(temp.next!=null){
            System.out.println(temp.val+" ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
    public void removeFirst(Node head) {
       if(head == null) {
           System.out.println("Empty List, nothing to delete");
           return;
       }
       head = head.next;
   }
    public Node reverse(Node A){
        Node prev = null;
        Node curr = A;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        A = prev;
        return A;
    }
}
public class Linkedlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node n1 = new Node(5);
        n1.next = new Node(6);
        n1.next.next = new Node(7);
        n1.next.next.next = new Node(9);
        n1.next.next.next.next = new Node(11);

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5);
        ll.add(3);
        ll.add(7);
        ll.add(11);
        
        
    }
}

