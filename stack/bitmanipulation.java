import java.util.Scanner;

public class bitmanipulation {
    public static void main(String[] args) {
        // Given an array of the integer, find the pair with minimum xor value
        // Given an array of positive numbers return the max '&' value of any pair that is return max (A[i]&A[j]) (i!=j)
        // Given an array print all the subsequence of the array
       /* int[] arr = {17,3,11,10,6,2,3};
        int[] ar = {1,2,3};
        printSubsequences(ar);
        */
        Scanner sc = new Scanner(System.in);
       /* int div = sc.nextInt();
        int divisor = sc.nextInt();
        int ans = 0;
        
        while(div>=divisor){
            div -= divisor;
            ans++;
        }
        System.out.println(ans);
         */
        // int[] arr = {1,2,3};
        // int xor = 0;
        // for(int i=0;i<arr.length;i++){
        //     int no = (i+1)*(arr.length-i);
        //     if(no%2!=0){
        //         xor ^= arr[i];
        //     }
        // }
        // System.out.println(xor);
        // int[] arr= {-3,0,1,3,6,8,11,14,21,25};
        // int target = 5;
        // int start = 0;
        // int end = arr.length-1;
        // System.out.println(twopointer(arr, target));
       // Given three sorted arrays A,B and C find i,j and k such that max(A[i],B[j],C[k])-min(A[i],B[j],C[k]) is maximised
    }
    static boolean twopointer(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            if(arr[start]==arr[end]+target){
                return true;
            }
            if(arr[start]<arr[end]+target){
                start++;
            }else{
                end--;
            }
        }
        return false;
    }
    static int binarysearch(int[]A,int target){
        int n = A.length;
        int s = 0;

        int e = n-1;
        int mid = s + (e-s)/2;
        while(s<=e){
            if(target==A[mid]){
                return mid;
            }
            if(target>A[mid]){
                s = mid+1;
            }else{
                e = mid-1;
            }
            mid = s + (e-s)/2;
        }
        return -1;
    }
        static boolean check(int x, int[] A, int c) {
           int j = 0, n = A.length;
           int cnt = 1;
           for (int i = 1; i < n; i++) {
              if (A[i] - A[j] >= x) {
                 j = i;
                 cnt++;
              }
           }
           return (cnt >= c);
        }
     
        static int answer(int[] A, int B) {
           int n = A.length;
           Arrays.sort(A);
           int l = 1, r = 1000 * 1000 * 1000;
           int ans = 1;
           while (l <= r) {
              int mid = (l + r) / 2;
              if (check(mid, A, B)) {
                 ans = mid;
                 l = mid + 1;
              } else {
                 r = mid - 1;
              }
           }
           return ans;
        }
     
    
    static int minxor(int arr[]){
        int n = arr.length;
        int minxor = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                minxor = Math.min(minxor, arr[i]^arr[j]);
            }
        }
        return minxor;
    }
    static void printSubsequences(int[] arr) {
        int n = arr.length;

        // Total number of possible subsequences is 2^n
        int totalSubsequences = (int) Math.pow(2, n);

        // Iterate through all possible binary representations from 0 to 2^n - 1
        for (int i = 0; i < totalSubsequences; i++) {
            System.out.print("{ ");

            // Iterate through each element of the array
            for (int j = 0; j < n; j++) {

                // Check if the jth bit of i is set (1) or not (0)
                if ((i & (1 << j)) > 0) {
                    // If set, print the jth element of the array
                    System.out.print(arr[j] + " ");
                }
            }

            System.out.println("}");
        }
    }
}