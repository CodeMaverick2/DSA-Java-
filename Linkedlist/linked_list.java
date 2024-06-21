class Node{
    int val;
    Node next;
    public Node(int v){
        this.val = v;
        this.next = null;
    }
}
public class linked_list {

    static Node insertStart(Node head, int v){
        Node N = new Node(v);
        N.next = head;
        return N;
    }

    static Node insertEnd(Node head,int v){
        Node last = new Node(v);
        Node end = head;
        if(end == null){
            return last;
        }
        while(end.next!=null){
            end = end.next;
        }    
        end.next = last;
        return head;
    }

    static Node insertAtK(Node head, int v, int pos){
        Node temp = head;
        Node k = new Node(v);
        for(int i=1;i<pos;i++){
            temp = temp.next;
        }    
        k.next = temp.next;
        temp.next = k;
        return head;
    }
    static Node print(Node v){
        Node temp = new Node(v);
        temp.next = next;
        while(temp.next!=null){
            System.out.println(temp.val+" ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
   

    public static void main(String[] args) {
        Node n1 = new Node(4);
        n1.next = new Node(8);
        n1.next.next = new Node(10);
        n1.next.next.next = new Node(12);
        System.out.println(insertStart(n1, 6));
    }
}