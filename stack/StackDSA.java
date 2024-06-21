import java.util.*;
import java.util.Stack;
public class StackDSA {
    public static void main(String[] args) {
        int arr[] = {100,80,60,70,60,75,85};
        int[] ans = stockspan(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
    // Stockspan problem to find the number of stock before it which are less than it or equal.
    public static int[] stockspan(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i] = i+1;
            }else{
                ans[i] = i-s.peek();
            }
            s.push(i);
        }
        return ans;
    }
    public static int[] prevsmaller(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int index = 0;
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!s.empty() && s.peek() >= arr[i]){
                s.pop();
                index--;
            }
            if(s.empty()){
                ans[i] = -1;
            } else{
                ans[i] = index;
            }
            s.push(arr[i]);
            index++;
        }
        return ans;
    }

}
