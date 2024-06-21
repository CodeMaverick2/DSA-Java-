import java.util.Scanner;

public class Lecture1 {
    public static void tellswappair(int[] A){
        int n = A.length;
        int max = A[0];
        int min = 0;
        boolean check = false;
        for(int i=0;i<n;i++){
            if(A[i]<A[max]){
                max = i;
                check = true;
            }else if(!check){
                max = i;
            }
            if(A[i]>A[min] && check == true){
                min = i;
            }
        }
        System.out.println(min+" "+max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = {3,4,14,10,11,7,17,19};
        tellswappair(arr);
        
    }
}