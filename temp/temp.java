import java.util.*;
class Exchange{
    int x;
    int y;
    public Exchange(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class temp {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Thread currentThread = Thread.currentThread();
        System.out.println("Thread Name: " + currentThread.getName());
        System.out.println("Thread ID: " + currentThread.getId());
        System.out.println("Thread Priority: " + currentThread.getPriority());
        System.out.println("Thread State: " + currentThread.getState());
        // int B = 3;
        // int[] A = {1, 3, -1, -3, 5, 3, 6, 7};

        // Deque<Integer> q = new ArrayDeque<>();
        // int[] ans = new int[A.length-B+1];
        // int k = 0;
        // for(int i=0;i<A.length;i++){
        //     if(!q.isEmpty() && q.peek()==i-B){
        //         q.pop();
        //     }
        //     while(!q.isEmpty() && A[q.peekLast()]<=A[i]){
        //         q.pollLast();
        //     }
        //     q.add(i);
        //     if(i>=B-1){
        //         ans[k++] = A[q.peek()];
        //     }
        // }
        // for(int i=0;i<ans.length;i++){
        //     System.out.println(ans[i]);
        // }
        // int A = 5;
        // ArrayList<Integer> ans = new ArrayList<>();
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while(ans.size()<A){
        //     int e = q.poll();
        //     ans.add(e);
        //     q.add(e*10+1);
        //     q.add(e*10+2);
        //     q.add(e*10+3);
        // }
        // for(int i=0;i<ans.size();i++){
        //     System.out.println(ans.get(i));
        // }
        // int[] A = {2,1,2,1,3};
        // int[] B = {100,19,27,25,15};
        // Exchange[] arr = new Exchange[A.length];
        // for(int i=0;i<A.length;i++){
        //     arr[i] = new Exchange(A[i],B[i]);
        // }
        // // Arrays.sort(arr, new Comparator<Exchange>(){
        // //     public int compare(Exchange a, Exchange b){
        // //         if(a.y>b.y){
        // //             return -1;
        // //         }
        // //         return 1;
        // //     }
        // // });
        // Arrays.sort(arr, (a,b) -> b.y - a.y);
        // int max = 0;
        // for(int i=0;i<A.length;i++){
        //     if(arr[i].x>max){
        //         max = arr[i].x;
        //     }
        // }
        // for(int i=0;i<A.length;i++){
        //     System.out.println(arr[i].x+" "+arr[i].y);
        // }
        // int ans = 0;
        // int[] store = new int[A.length];
        // for(int i=0;i<A.length;i++){
        //     int curr = arr[i].x-1;
        //     int b = arr[i].y;
        //     if(store[curr]==0){
        //         store[curr] = b;
        //         ans += b;
        //     }else{
        //         while(store[curr]!=0 && curr>0){
        //             curr--;
        //         }
        //         if(store[curr]==0 && curr>=0){
        //             store[curr] = b;
        //             ans += b;
        //         }
        //     }

        // }
        // System.out.println(ans+"  le anus");
    }
}
