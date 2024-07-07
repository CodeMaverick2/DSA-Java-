import java.util.LinkedList;
import java.util.Queue;

public class Building_Tress {
    // Node Class
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    // Class to make a binary tree 
    static class Binarytree{
        static int indx = -1;
        static Node Buildtree(int[] nodes){
            indx++;
            if(indx == nodes.length){
                return null;
            }
            if(nodes[indx] == -1){
                return null;
            }
            Node naya = new Node(nodes[indx]);
            naya.left = Buildtree(nodes);
            naya.right = Buildtree(nodes);
            return naya;
        }
    }

    static class Treeinfo{
        int height;
        int diam;
        Treeinfo(int height, int diam){
            this.height = height;
            this.diam = diam;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            //System.out.print(-1+" ");
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+" ");
    }
    public static Treeinfo diameterofbinarytree(Node root){
        if(root == null){
            return new Treeinfo(0,0);
        }
        Treeinfo left = diameterofbinarytree(root.left);
        Treeinfo right = diameterofbinarytree(root.right);
        int height = Math.max(left.height, right.height) + 1;
        int diam = Math.max(left.height + right.height + 1, Math.max(left.diam, right.diam));
        return new Treeinfo(height, diam);
    }
    

    public static int countofnodes(Node root){
        if(root == null){
            return 0;
        }
        int leftnodes = countofnodes(root.left);
        int rightnodes = countofnodes(root.right);
        return leftnodes + rightnodes + 1;
    }

    public static int sumofnodes(Node root){
        if(root == null){
            return 0;
        }
        int leftsum = sumofnodes(root.left);
        int rightsum = sumofnodes(root.right);
        return leftsum + rightsum + root.val;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        int height = Math.max(leftheight, rightheight) + 1;
        return height;
    }

    public static int diameter(Node root){
        // Time complexity O(N^2)
        if(root == null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;
        return Math.max(diam3,Math.max(diam1, diam2));
    }
    public static boolean isIdentical(Node root, Node subtree){
        if(root == null && subtree == null){
            return true;
        }
        if(root == null || subtree == null){
            return false;
        }
        if(root.val == subtree.val){
            return isIdentical(root.left, subtree.left) && isIdentical(root.right, subtree.right);
        }
        return false;
    }
    public static boolean isSubtree(Node root, Node subtree){
        if(subtree == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(root.val == subtree.val){
            if(isIdentical(root, subtree)){
                return true;
            }
        }
        return isSubtree(root.left, subtree) || isSubtree(root.right, subtree);
    }
    public static boolean isSametree(Node root, Node secroot){
        if(root==null && secroot==null){
            return true;
        }
        if(root == null || secroot == null){
            return false;
        }
        return (root.val == secroot.val) && isSametree(root.left, secroot.left) && isSametree(root.right,secroot.right);

    }

    public static void levelorder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
    
        while(!q.isEmpty()){
            Node  curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.val+" ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static void levelorder1(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            System.out.print(curr.val+" ");
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }
    public static void levelorder2(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.remove();
                System.out.print(curr.val+" ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binarytree tree = new Binarytree();
        Node root = tree.Buildtree(nodes);
        levelorder(root);

        //levelorder(root);
        //preorder(root);
        //  inorder(root);
        // postorder(root);
        // System.out.println(diameter(root));

    }
    
}