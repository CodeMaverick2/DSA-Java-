import java.util.Scanner;

public class sortingarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ### Sorting a array in ascending order
        System.out.println("Enter the size of a array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array: ");
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int store = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[i]) {
                    store = arr[i];
                    arr[i] = arr[j];
                    arr[j] = store;

                }
            }
        }
        System.out.print("The sorted array is : ");
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
    }
    
    
}
