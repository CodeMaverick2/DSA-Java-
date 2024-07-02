import java.lang.reflect.Array;
import java.util.ArrayList;

public class Revision {
    static int ans = 0;
    public static void main(String[] args) {
        int x = 12;
        sol(x);
        System.out.println(ans);
    }
    public static void sol(int n){
        if(minsqrt(n)*minsqrt(n)==n){
            ans++;
            return;
        }
        ans++;
        sol(n-minsqrt(n)*minsqrt(n));
        
    }
    public static int minsqrt(int n){
        return (int)Math.sqrt(n);
    }
    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        return x*(power(x,n-1));
    }

    public static void sum(int n){
        if(n==1){
            System.out.println(1);
            return;
        }
        for(int i=1;i<=n;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        sum(n-1);
        for(int i=1;i<=n;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

