class Heap1{
    int[] A;
    int size;
    public Heap1(int n){
        A = new int[n];
        size = A.length;
    }
}
public class Heap {
    public static void deleteMin(Heap1 B){
        int size = B.size;
        int temp = B.A[0];
        B.A[0] = B.A[size-1];
        B.A[size-1] = temp;
        B.size--;
        size = B.size;
        for(int i=0;i<size;i++){
            if(2*i+1>=size || 2*i+2>=size){
                break;
            }
            int l = B.A[2*i+1];
            int r = B.A[2*i+2];
            if(l>r && B.A[i]>r){
                int store = B.A[i];
                B.A[i] = r;
                B.A[2*i+2] = store;
            }else if(r>l && B.A[i]>l){
                int store = B.A[i];
                B.A[i] = l;
                B.A[2*i+1] = store;
            }else{
                break;
            }
        }
    }
    public static void printheap(Heap1 A){
        int size = A.size;
        for(int i=0;i<size;i++){
            System.out.println(A.A[i]);
        }
        System.out.println("Deleted element "+ A.A[size]);
    }
    public static void main(String[] args) {
        Heap1 h = new Heap1(9);
        int[] a = {-1,2,1,3,5,6,4,7,4};
        int[] b = {3,4,16,5,8,17,20,9,11};
        // deleteMin(h);
        // printheap(h);
        for(int i=0;i<b.length;i++){
            h.A[i] = b[i];
        }
        deleteMin(h);
        printheap(h);
    }
    public int findKthLargest(int[] nums, int k) {
        Heap1 h = new Heap1(nums.length);
        for(int i=0;i<nums.length;i++){
            h.A[i] = nums[i];
        }
        for(int i=0;i<k;i++){
            deleteMin(h);
        }
        return h.A[h.size];
    }
    public int findKthSmallest(int[] nums, int k) {
        Heap1 h = new Heap1(nums.length);
        for(int i=0;i<nums.length;i++){
            h.A[i] = nums[i];
        }
        for(int i=0;i<k;i++){
            deleteMin(h);
        }
        return h.A[h.size];
    }

}

