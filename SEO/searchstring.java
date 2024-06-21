import java.util.HashMap;
class TrieNode{
    HashMap<Character,TrieNode> map;
    boolean isEndOfA;
    public TrieNode(){
        map = new HashMap<Character,TrieNode>();
        isEndOfA = false;
    }
}

public class searchstring {
    public static void insertTrie(TrieNode root,String A){
        TrieNode current = root;
        for(int i=0;i<A.length();i++){
            Character c = A.charAt(i);
            if(!current.map.containsKey(c)){
                current.map.put(c, new TrieNode());
            }
            current = current.map.get(c);
        }
        current.isEndOfA = true;
    }

    public static boolean searchTrie(TrieNode root, String A){
        TrieNode current = root;
        for(int i=0;i<A.length();i++){
            Character c = A.charAt(i);
            if(!current.map.containsKey(c)){
                return false;
            }
            current = current.map.get(c);
        }
        return current.isEndOfA;
    }
    public static String delete(TrieNode root,String A){
        if(!searchTrie(root, A)){
            String ans = "Entered string not found";
            return ans;
        }
        TrieNode current = root;
        for(int i=0;i<A.length();i++){
            Character c = A.charAt(i);
            current = current.map.get(c);
        }
        current.isEndOfA = false;
        return "Done";
    }
    public static void main(String[] args) {
        String a = "aabb";
        String b = "aabbc";
        String c = "aabbb";
        TrieNode t = new TrieNode();
        insertTrie(t, a);
        insertTrie(t, b);
        insertTrie(t, "aa");
        insertTrie(t, "aab");
        // System.out.println(searchTrie(t, a));
        System.out.println(searchTrie(t, "aa"));
        System.out.println(delete(t, "aa"));
        System.out.println(searchTrie(t, "aa"));
        System.out.println(delete(t, "aab"));
        System.out.println(searchTrie(t, "aab"));
        insertTrie(t, "aa");
        System.out.println(searchTrie(t, "aa"));

    }
}


    