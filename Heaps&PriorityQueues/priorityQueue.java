import java.util.*;

public class priorityQueue {
    public static void main(String[] args) {
        // int[]arr = {7,2,9,1,10,3,5,8,12,50};
        // int[] A = {3,2,1,5,6,4};
        // int k = 2;
        // int[] ans = smallestk(arr, k);
        // k_sorted(A, k);
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(A[i]+" ");
        // }
        // System.out.println();
        // PriorityQueue<Integer> hj = new PriorityQueue<>();
        // hj.add(468);
        // hj.add(335);
        // System.out.println(hj.poll());
        int[] reward = {100,19,27,25,30};
        int[] arr = {3,1,2,1,3};
        
    }
    public static int maxreward(int[] time, int[] reward){
        int ans = 0;
        int n = time.length;
        sortwith2(reward, time);
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,time[i]);
        }
        int[] store = new int[max];
        int co = 0;
        int presentin = 0;
        for(int i=0;i<n;i++){
            if(co==max){
                break;
            }
            if(store[time[i]-1]==0){
                store[i] = reward[i];
                presentin = time[i]-2;
                co++;
            }
        }
        return ans;
    }
    public static void sortwith2(int[] a, int[] b){
        int n = a.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a[i]<a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
    }
    public static int fractional_Kmapsack(int[][] A, int w){
        int ans = 0;
        int store = 0;
        // while(store!=w){

        // }
        return ans;
    }
    public static int maxval(int[][] A){
        int ans = 0;
        int j = 0;
        for(int i=0;i<A.length;i++){
            if(A[i][0]/A[i][1] > ans){
                ans = A[i][0] / A[i][1];
                j = i;
            }
        }
        return j;
    }
    public static int minsubseq(int[] A, int k){
        int ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<A.length;i++){
            q.add(A[i]);
        }
        for(int i=0;i<k;i++){
            ans += q.poll();
        }
        return ans;
    }
    public static int[] smallestk(int[] arr,int k){
        int[] ans = new int[k];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            q.add(arr[i]);
        }
        for(int i=0;i<k;i++){
            ans[i] = q.poll();
        }
        return ans;
    }
    public static void k_sorted(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<=k && i<arr.length;i++){
            minHeap.add(arr[i]);
        }
        
    }
}
