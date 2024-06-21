import java.util.*;
public class prime {
    public static void addnums(HashMap<Integer, Integer> naksha, int i,int n){
        for(int j=1;j*i<n;j++){
            if(!naksha.containsKey(j)){
                naksha.put(j*i, j*i);
            }
            //System.out.println(j*i+" kkff");
        }
    }
    public static int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        HashMap<Integer, Integer> naksha = new HashMap<>();
        for(int i=0;i<n;i++){
            A[i] %= B;
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(A[i]);
        // }
        for(int i=0;i<n;i++){
            if(naksha.containsKey(A[i])){
                naksha.put(A[i],naksha.get(A[i])+1);
            }else{
                naksha.put(A[i],1);
            }
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(naksha.get(A[i]));
        // }
        int ne = -4;
        for(int i=0;i<n;i++){
            if(naksha.get(A[i])<0){
                continue;
            }
            int st = B - naksha.get(A[i]);
            System.out.println(st+" st");
            if(naksha.containsKey(st)){
                count += naksha.get(A[i])*naksha.get(st);
                System.out.println(count+ " count");
                naksha.put(A[i], ne);
            }
            ne *= 3;
        }
        return count;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        // HashMap<Integer, Integer> naksha = new HashMap<>();
        // // System.out.println(4);
        // int n = 128;
        // int m = 32;
        // int count = 0;
        // System.out.println(1%2);
        // for(int i=1;i<=n;i++){
        //     if(n%i == m%i){
        //         count++;
        //         System.out.println(i+" ee");
        //         // if(count==2){
        //         //     break;
        //         // }
        //     }
        // }
        // System.out.println("Count is "+count);
            int[] arr = {5,17,100,11};
            int b = 28;
        System.out.println(solve(arr,b));

        sc.close();
    }
}
