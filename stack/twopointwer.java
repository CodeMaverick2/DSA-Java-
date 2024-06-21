public class twopointwer {
    public static void main(String[] args) {
        // int[] A = {3,14,16,23};
        // int[] B = {-6,23,24,30};
        // int[] C = {-15,15,26,36};
        // System.out.println(minofthree(A, B, C));
        // int[] A = {3,7,4,5,2};
        // System.out.println(maxarea(A));
        
        // ### Given an array A[N] and an int B, return the minimmum swaps required
        //        to bring all elements <=B together
        int[] arr = {1,10,12,14,3,5,10};
        int target = 8;
        System.out.println(minSwap(arr, target));
    }
    public static int minSwap(int arr[], int k){
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i] <= k){
                count++;
            }
        }
        int bad = arr.length-count;
        int ans = bad;
        for(int i=0, j=count;j<n;i++,j++){
            if(arr[i]>k){
                bad--;
            }
            if(arr[j] > k){
                bad++;
            }
            ans = Math.min(ans, bad);
        }
        return ans;
    }
    public static int maxarea(int[] arr){
        int l = 0;
        int r = arr.length-1;
        int max = -1;
        while(l<r){
            int min = Math.min(arr[l], arr[r]);
            int val =min*(r-l);
            if(val>max){
                max = val;
            }
            if(arr[l]<=arr[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max; 
    }
    public static int minofthree(int[] A, int[] B, int[] C){
        int i = A.length-1;
        int j = B.length-1;
        int k = C.length-1;
        int mindif = Math.abs(max(A[i], B[j], C[k]) - min(A[i], B[j], C[k]));
 
        while(i>0 && j>0 && k>0){
            int curdif = Math.abs(max(A[i], B[j], C[k]) - min(A[i], B[j], C[k]));
            if(curdif<mindif){
                mindif = curdif;
            }
            int maxterm = max(A[i], B[j], C[k]);
            if(A[i] == maxterm){
                i--;
            }
            else if(B[j] == maxterm){
                j--;
            }
            else{
                k--;
            }
        }
        return mindif;
    }
    public static int max(int A, int B, int C){
        int max = 0;
        max = Math.max(A,Math.max(B,C));
        return max;
    }
    public static int min(int A, int B, int C){
        int min = 0;
        min = Math.min(A,Math.min(B,C));
        return min;
    }
 
    public static boolean twoSum(int[] input, int targetValue){

        int pointerOne = 0;
        int pointerTwo = input.length - 1;
        while (pointerOne < pointerTwo) {
            int sum = input[pointerOne] + input[pointerTwo];
    
            if (sum == targetValue) {
                return true;
            } else if (sum < targetValue) {
                pointerOne++;
            } else {
                pointerTwo--;
            }
        }
    
        return false;
    }
}
