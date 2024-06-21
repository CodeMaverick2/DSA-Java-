public class example {
    public static void main(String[] args) {
        // System.out.println(fibb(7));
        // System.out.println(linearfibb(7));
        // String s = "11";
        // printstring(s);
        int[][] A = {{1,0,0},{0,1,0},{0,0,1},{1,0,0}};
        int n = 4;
        int m = 3;
        // int[][] A = new int[n][m];
        // for(int i=0;i<m;i++){
        //     A[0][i] = 1;
        // }
        // for(int i=0;i<n;i++){
        //     A[i][0] = 1;
        // }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i][j]==1){
                    A[i][j] =  -1;
                    continue;
                }
                if(A[i][0]==0){
                    A[i][0] = 1;
                }else if(A[0][j]==0){
                    A[0][j] = 1;
                }

            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(A[i][j]==-1){
                    continue;
                }
                if(A[i-1][j]!=-1 && A[i][j-1]!=-1){
                    A[i][j] = A[i-1][j] + A[i][j-1];
                }else{
                    continue;
                }
                
            }
        }





        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void printstring(String s){
        int num = 0;
        for(int i=0;i<s.length();i++){
            num += s.charAt(i)*10;
        }
        System.out.println(num);
    }
    public static int lineAecusrionFibbonacci(int n){
        // Aay me store karna he har ek step ka value or
        // fir check karnege ki agar us jagah pe value he ya nahi 
        // so as intializing Aay with -1
        if(n<=1){
            return n;
        }
        return n;
    }
    public static int linearfibb(int n){
        if(n<=1){
            return n;
        }
        int fr = 0;
        int sum = 1;
        for(int i=1;i<n;i++){
            int store = sum;
            sum = sum+fr;
            fr = store;
        }
        return sum;
    }

    public static int fibb(int n){
        if(n<=1){
            return n;
        }
        return fibb(n-1)+fibb(n-2);
    }
}
