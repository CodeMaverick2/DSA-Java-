public class recursion {
    public static void main(String[] args) {
    //    String A = "scaler";
    //    int[][] arr = {{0, 2}, {2, 4}};
    //    int[] a = solve(A, arr);
    //    for(int i=0;i<a.length;i++){
    //     System.out.println(a[i]+" ");
    //    }
       print(5);
    }
    public static void print(int n){
        if(n>=0){
            System.out.println(n);
            print(n-1);
        }
    }
    public static int[] solve(String A, int[][] B) {
        int n = A.length();
        int[] prefsum = new int[n+1];
        prefsum[0] = 0;
        for(int i=0;i<n;i++){
            char b = A.charAt(i);
            if(b=='a' || b=='e' || b=='i' || b=='o' || b=='u'){
                prefsum[i+1] = prefsum[i]+1;
            }else{
                prefsum[i+1] = prefsum[i];
            }
        }
        int[] ans = new int[B.length];
        for(int i=0;i<B.length;i++){
            ans[i] = prefsum[B[i][1]+1] - prefsum[B[i][0]];
        }
        return ans;
    }
    static void solve(int A){
        if(A==0){
            return;
        }else{
            System.out.print(A+" ");
            solve(A-1);
            System.out.print(A+" ");
            solve(A-1);
            System.out.print(A+" ");
        }
    }
    static int maxelem(int[] A, int g){
        int h = 0;
        for(int i=1;i<g;i++){
            if(A[i]>A[h]){
                h = i;
            }
        }
        return h;
    }
    static int digitsum(int A){
        if(A==0){
            return 0;
        }else{
            int sum = A%10;
            digitsum(A/10);
            return sum; 
        }
    }
    static void print5(int i){
        if(i<=5){
            System.out.print(i+" ");
            print5(i+1);
        }
    }
    static void empty(int i){
        print5(i);
        System.out.println("Hello wolrd");
    }
}
