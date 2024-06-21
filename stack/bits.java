public class bits {
    public static void main(String[] args) {
        // double[] arr = {5, 18, 15, 7, 23, 220, 130, 85, 103, 25, 80, 7, 24, 6, 13, 65, 37, 25, 24, 65, 82, 95, 77, 15, 70,
        //     110, 44, 28, 33, 81, 29, 14, 45, 92, 17, 53};
        // //System.out.println(arr.length);
        // double mean = 0;
        // for(double i : arr){
        //     mean += i;
        // }
        // System.out.println(mean/36.0);
        // mean = mean/36.0;
        // System.out.println(mean);
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = (int)(mean - arr[i]);
        //     arr[i] *= arr[i];

        // }
        // double t = 0;
        // for(double i : arr){
        //     t += i;
        // }
        // System.out.println(t);
        // int s = 1;
        // for(int i=1;i<26;i++){
        //     s *= i;
        //     s = s%(1000*1000*1000+7);
        // }
        // System.out.println(s);
        // int d= 1;
        // for(int i=1;i<20;i++){
        //     d *= i;
        //     d = d%(1000*1000*1000+7);
        // }
        // System.out.println(d);
        // System.out.println(s/d);
        message(90);

    }
    public static void message(double n){
        if(n==100){
            return;
        }else{
            System.out.println(n);
        }
        if(n%2==0){
            System.out.println(n);
        }
        message(n+1);
    }

}