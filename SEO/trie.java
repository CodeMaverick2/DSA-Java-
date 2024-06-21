import java.util.*;
class Trie{
    HashMap<String, Trie> map;
    boolean isEnd;
    boolean isRepeating;
    public Trie(){
        map = new HashMap<String, Trie>();
        isEnd = false;
        isRepeating = false;
    }
}
public class trie {
    public static void insert(Trie t, int[] arr){
        Trie curr = t;
        for(int d : arr){
            if(!curr.map.containsKey(d)){
                curr.map.put(d,new Trie());
            }
            curr = curr.map.get(d);
        }
        if(curr.isEnd){
            curr.isRepeating = true;
        }
        curr.isEnd = true;
    }
    public static boolean search(Trie t, int[] arr){
        Trie curr = t;
        for(int r : arr){
            if(!curr.map.containsKey(r)){
                return false;
            }
            curr = curr.map.get(r);
        }
        return curr.isEnd;
    }
    public static boolean distinctrows(Trie t, int[] arr){
        Trie curr = t;
        for(int i=0;i<arr.length;i++){
            curr = curr.map.get(arr[i]);
        }
        return curr.isRepeating;
    }
    
    public static void main(String[] args) {
        Trie t = new Trie();
        // int[][] arr = {
        //     {1,0,0,1,0},
        //     {0,1,0,1,0},
        //     {1,1,0,1,1},
        //     {1,1,0,0,1},
        //     {1,1,0,1,1},
        //     {1,0,0,1,0},
        //     {1,0,1,0,1},
        //     {0,0,1,1,0}
        // };
        // int count = 0;
        // for(int i=0;i<arr.length;i++){
        //     insert(t,arr[i]);
        //     if(!distinctrows(t,arr[i])){
        //         count++;
        //     }
        // }
        // System.out.println(count);
        String s = "catsanddog";
        String[] arr = new String[5];
        arr[0] = "cat";
        arr[1] = "cats";
        arr[2] = "and";
        arr[3] = "sand";
        arr[4] = "dog";
        for(int i=0;i<arr.length;i++){
            insert(t, arr[i]);
        }
    }
}
