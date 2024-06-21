class Stack{
    int[] arr;
    int capacity;
    int top;
    int index;
    public Stack(int N){
        this.arr = new int[N];
        this.capacity = N;
        this.top = top;
        this.index = index;
    }
    public void push(int x){
        if(arr.length==capacity){
            for(int i=1;i<capacity;i++){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }

        }
    }
    public int pop(){
        if(isempty()){
            return -1;
        }
        int temp = arr[0];
        arr[0] = 0;
        index--;
        return temp;
    }
    public boolean isempty(){
        return arr.length==0;
    }
    public int peek(){
        if(isempty()){
            return -1;
        }
        return arr[index];
    }
    public void printstack(){
        if(isempty()){
            System.out.println("Stack is empty");
        }
        for(int i=index-1;i>=0 && arr[i]!=0;i--){
            System.out.println(arr[i]);
        }
    }
}
public class aarraystack {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Stack s1 = new Stack(5);
        s1.push(5);
        s1.push(3);
        s1.push(87);
        s1.push(8);
        s1.pop();
        s1.printstack();
    }
}
