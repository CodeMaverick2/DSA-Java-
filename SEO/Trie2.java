import java.util.HashMap;

class Trienod{
    HashMap<Integer,Trienod> map;
    boolean isEndOfWord;
    boolean repeating;
    Trienod(){
        map = new HashMap<Integer,Trienod>();
        isEndOfWord = false;
        repeating = false;
    }
}

public class Trie2 {
    public static void insertTrienod(Trienod root,int[] arr){
        int N = arr.length;
        Trienod current = root;
        for(int i=0;i<N;i++){
            int c = arr[i];
            if(!current.map.containsKey(c)){
                current.map.put(c, new Trienod());
            }
            current = current.map.get(c);
        }
        if(current.isEndOfWord) current.repeating = true;
        current.isEndOfWord = true;
    }
    public static boolean searchTrienod(Trienod root, int[] arr){
        Trienod current = root;
        int N = arr.length;
        for(int i=0;i<N;i++){
            int c = arr[i];
            current = current.map.get(c);
        }
        return current.repeating;
    }

    public static void main(String[] args) {
        Trienod root = new Trienod();
        int[][] A = {{1,0,0,1,0},{0,1,0,1,0},{1,1,0,1,1},{1,1,0,0,1},{1,1,0,1,1},{1,0,0,1,0},{1,0,1,0,1},{0,0,1,1,0}};
        int count = 0;
        for(int i=0;i<A.length;i++){
            insertTrienod(root,A[i]);
            if(!searchTrienod(root, A[i])){
                count++; 
            }
        }
        System.out.println(count);
    }
}