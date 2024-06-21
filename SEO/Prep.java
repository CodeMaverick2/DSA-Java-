import java.util.*;
public class Prep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // // list_Primes(n);
        // System.out.println(isPrime(n));
        int[] A = {2, 1, 2, 1, 3};
        int[] B = {100, 19, 27, 25, 15};
        // int c = 28;
        // System.out.println(solve(B,28));
        answer_theFuck(A, B);
        sc.close();
    }
    public static void answer_theFuck(int[] A, int[] B){
        sort_two(B,A);
        int max = 0;
        int n = A.length;
        int[] store = new int[max+1];
        for(int i=0;i<n;i++){
            if(A[i]>max){
                max = A[i];
            }
            store[i] = -1;
        }
        
        int sum = 0;
        for(int i=1;i<n;i++){
            int ch = A[i-1];
            if(max==0){
                break;
            }
            if(store[ch]!=-1){
                store[ch] = i;
                sum += B[i-1];
                max--;
            }else if(ch>1){
                while(store[ch]==-1 && ch>1){
                    ch--;
                }
                if(store[ch]==-1 && ch>0){
                    store[ch] = i;
                    sum += B[i-1];
                    max--;
                }
            }
        }
        System.out.println(sum);

    }
    public static void sort_two(int[] A, int[] B){
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(A[i]<A[j]){
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    temp = B[i];
                    B[i] = B[j];
                    B[j] = temp;
                }
            }
        }
        // for(int i=0;i<A.length;i++){
        //     System.out.println(A[i]+" "+B[i]);
        // }
    }
    public static int solve(int[] A, int B) {
        int sum = 0;
        int n = A.length;
        for(int i=0;i<n;i++){
            A[i] %= B;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(A[i])){
                map.put(A[i],map.get(A[i])+1);
            }else{
                map.put(A[i],1);
            }
        }
        for(int i=0;i<n;i++){
            int st = B - A[i];
            if(A[i]==0 && map.containsKey(0) && map.get(0)>1){
                sum += map.get(0)-1;
                map.put(0, map.get(0)-1);
            }else if(st==A[i] && map.containsKey(st) && map.get(st)>1){
                sum += map.get(st)-1;
                map.put(st, map.get(st)-1);
            }else if(map.containsKey(st) && map.get(st)>0){
                sum += map.get(st);
                map.put(A[i], map.get(A[i])-1);
            }
        }
        // for(int i=0;i<map.size();i++){
        //     System.out.println(map.get(i));
        // }
        return sum;
    }
    public static boolean isPrime(int A){
        for(int i=2;i*i<A;i++){
            if(A%i==0){
                return false;
            }
        }
        return true;
    }
    public static void factors(int A){
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=2;i*i<=A;i++){
            count++;
            while(A%i==0){
                list.add(i);
                A/=i;
            }
        }
        if(A>1){
            list.add(A);
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println(count+" count");
    }
    public static void list_Primes(int A){
        boolean[] prime = new boolean[A+1];
        for(int i=2;i<=A;i++){
            prime[i] = true;
        }
        for(int i=2;i*i<=A;i++){
            if(prime[i]){
                for(int j=i*i;j<=A;j+=i){
                    prime[j] = false;
                }
            }
        }
        for(int i=2;i<=A;i++){
            if(prime[i]){
                System.out.print(i+" ");
            }
        }
    }
}
