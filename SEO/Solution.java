import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(1);
        // arr.add(2);
        // arr.add(3);
        // ArrayList<ArrayList<Integer>> ans = subsets(arr);
        // for(int i=0;i<ans.size();i++){
        //     for(int j=0;j<ans.get(i).size();j++){
        //         System.out.print(ans.get(i).get(j)+" ");
        //     }
        //     System.out.println();
        // }
        int[] arr = new int[3];
        for(int i=0;i<3;i++){
            arr[i] = i+1;
        }
        generateSubsequences(arr, null, 0);
    }
    public static void generateSubsequences(int[] arr, String current, int index){
        if(index == arr.length){
            System.out.println(current);
            return;
        }
        generateSubsequences(arr, current, index+1);
        generateSubsequences(arr, current+arr[index]+",", index+1);
    }
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
    Collections.sort(A);
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    generateSubsets(A, new ArrayList<>(), 0, result);
    return result;
}

public static void generateSubsets(ArrayList<Integer> A, ArrayList<Integer> current, int index, ArrayList<ArrayList<Integer>> result) {
    result.add(new ArrayList<>(current));
    for (int i = index; i < A.size(); i++) {
        current.add(A.get(i));
        generateSubsets(A, current, i + 1, result);
        current.remove(current.size() - 1);
    }
}
}