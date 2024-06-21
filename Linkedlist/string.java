import java.util.Scanner;

public class string {
    static int vowels(String A){
        A = A.toLowerCase();
        int count = 0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='a' || A.charAt(i)=='e' || A.charAt(i)=='i' || A.charAt(i)=='o' || A.charAt(i)=='u'){
                count++;
            }
        }
        return count;
    }
    static boolean palindrome(String A){
        for(int i=0;i<A.length()/2;i++){
            if(A.charAt(i)!=A.charAt(A.length()-i-1)){
                return false;   
            }
        }
        return true;
    }
    static String reverse(String A){
        String str = "";
        for(int i=A.length()-1;i>=0;i--){
            str += A.charAt(i);
        }
        return str;
    }
    static boolean equal(String A, String B){
        A = A.toLowerCase();
        B = B.toLowerCase();
        if(A.length()==B.length()){
            for(int i=0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt(i)){
                return false;
            }
        }
        return true;
        }else{
            return false;
        }
        
    }
    static boolean password(String A){
        if(A.length()>=8){
            int countup = 0;
            int countlo = 0;
            for(int i=0;i<A.length();i++){
                if((int)A.charAt(i)>=65 && (int)A.charAt(i)<=90 ){
                    countup++;
                }else if((int)A.charAt(i)>=97 && (int)A.charAt(i)<=122){
                    countlo++;
                }
            }
            if(countup>0 && countlo>0){
                int count = 0;
                for(int i=0;i<A.length();i++){
                    if((int)A.charAt(i)>=48 && (int)A.charAt(i)<=57){
                        count++;
                    }
                }
                if(count>0){
                    int countsp = 0;
                    for(int i=0;i<A.length();i++){
                        if((int)A.charAt(i)>=33 && (int)A.charAt(i)<=46){
                            countsp++;
                        }
                    }
                    if(countsp>0){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }

        }
        else{
            return false;
        }
    }
    // ### functions for checking password strength
    static int length(String A){
        if(A.length()>=8){
            return 1;
        }else{
            return 0;
        }
    }
    static int uppercase(String A){
        int countup = 0;
        for(int i=0;i<A.length();i++){
           if((int)A.charAt(i)>=65 && (int)A.charAt(i)<=90 ){
             countup++;
           }
        }
        if(countup>0){
            return 1;
        }else{
            return 0;
        }
    }
    static int lowercase(String A){
        int countlo = 0;
            for(int i=0;i<A.length();i++){
                if((int)A.charAt(i)>=97 && (int)A.charAt(i)<=122){
                    countlo++;
                }
            }
            if(countlo>0){
                return 1;
            }else{
                return 0;
            }
    }
    static int specialchar(String A){
        int countsp = 0;
        for(int i=0;i<A.length();i++){
            if((int)A.charAt(i)>=33 && (int)A.charAt(i)<=46){
                countsp++;
            }
        }
        if(countsp>0){
            return 1;
        }else{
           return 0;
        }
    }
    static int digits(String A){
        int count = 0;
        for(int i=0;i<A.length();i++){
           if((int)A.charAt(i)>=48 && (int)A.charAt(i)<=57){
               count++;
            }
        }
        if(count>0){
            return 1;
        }else{
            return 0;
        }
    }
    static String passwordcheck(String A){
        int count = 0;
        if(length(A)==1){
            count++;
        } if(uppercase(A)==1){
            count++;
        } if(lowercase(A)==1){
            count++;
        } if(specialchar(A)==1){
            count++;
        }if(digits(A)==1){
            count++;
        }
        if(count==5){
            return "Strong";
        }else if(count==4){
            return "Theek hai";
        }else if(count==3){
            return "Weak";
        }else if(count==2){
           return  "Poor";
        }else{
            return "Rejected";
        }
        
    }
    static int getfreq(String[] arr, String s){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(s.equals(arr[i])){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        System.out.println(passwordcheck(a));    
    }
}