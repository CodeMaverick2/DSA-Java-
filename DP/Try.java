import java.util.*;
public class Try {
    static List<Integer> list = new ArrayList<Integer>();
    static boolean flag = true;
    public static void main(String[] args) {
        // System.out.println("Hello World");
        // System.out.println(recurs(5));
        int[] arr = {3,1,2,1,3};
        subsequence(0, arr,4);
        System.out.println(sum);
    }
    static int sum = 0;
    public static void subsequence(int index, int[] arr,int target){
        if(flag){
        if(index==arr.length){
            if(sum == target){
                flag = false;
                System.out.println(list);
            }
            return;
        }
        list.add(arr[index]);
        sum += arr[index];
        subsequence(index+1, arr, target);
        sum -= arr[index];
        list.remove(list.size()-1);
        subsequence(index+1, arr, target);
    }
    public static int soe(int[] A, int B, int C){
        int[] dp = new int[A.length];
        Arrays.fill(dp,-1);
        return recu(0,A,B,C,dp);
    }
    public static int recu(int i, int[] A , int B, int C, int[] dp){
        if(i==A.length-1){
            return 0;
        }
        if(i==A.length-2){
            return B*(A[i+1]-A[i]);
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int l = B*(A[i+1]-A[i]) + recu(i+1,A,B,C,dp);
        int r = C*(A[i+2]-A[i]) + recu(i+2,A,B,C,dp);
        return dp[i] = Math.min(l,r);

    }
        
    }
    public static int recurs(int n){
        if(n<=1){
            return 0;
        }
        int firs = recurs(n-1);
        int sec = recurs(n-2);
        return firs+sec;
    }
}