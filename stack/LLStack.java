import java.util.Stack;

public class LLStack {
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            next = null;
        }
    }
    static class Stack{
        public static Node head;
        static int size = 0;
        public static boolean isEmpty(){
            return head==null;
        }
        public static void push(int val){
            Node newnode = new Node(val);
            size++;
            if(isEmpty()){
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
            
        }
        public static int size(){
            if(isEmpty()){
                return -1;
            }
            return size;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.val;
            head = head.next;
            size--;
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.val;
        }
        public static int findmid(){
            Node temp = head;
            Node mid = head;
            if(head.next==null){
                return mid.val;
            }
            int count = 0;
            
            while(temp!=null){
                if(count<2){
                    temp = temp.next;
                }
                count++;
                if(count==2){
                    mid = mid.next;
                    count = 0;
                }
            }
            return mid.val;
        }
        
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(5);
        s.push(3);
        s.push(7);
        s.push(14);
        s.push(1);
       // System.out.println(s.pop());
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }()
        System.out.println(s.findmid());

        
    }
}
