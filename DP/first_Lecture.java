package DP;
import java.util.*;
public class first_Lecture {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // System.out.println("The number of ways are : "+stairWalk(n));
        // sc.close();
        String s = "25";
        printstring(s);
    }
    public static void printstring(String s){
        int num = 0;
        for(int i=0;i<s.length();i++){
            num += s.charAt(i)*10;
        }
        System.out.println(num);
    }
    
    public static int stairWalk(int n){
        //Given n stairs to walk you can step i+1 or i+2 so how many different ways
        // u can reach the top for 3 steps it would be 3 as
        // first ->1 1 1 1 sec ->1 1 0 1 third -> 1 0 1 1
        return linearfibb(n+1);
    }
    public static int linearRecusrionFibbonacci(int n){
        // array me store karna he har ek step ka value or
        // fir check karnege ki agar us jagah pe value he ya nahi 
        // so as intializing array with -1
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
