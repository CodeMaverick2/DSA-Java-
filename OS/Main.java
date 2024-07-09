package OS;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NumberPrinter extends Thread{
    private int number;

    public NumberPrinter(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        System.out.println("Number: " + number + ", printed by thread: " + Thread.currentThread().getName());

    }
}

class NumberPrinterV2 implements Runnable{
    private int number;
    public NumberPrinterV2(int num){
        this.number = num;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(number + " " + Thread.currentThread().getName());
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}

class ListDoubler implements Callable<ArrayList<Integer>>{
    ArrayList<Integer> list = new ArrayList<>();

    public ListDoubler(ArrayList<Integer> list){
        this.list = list;
    }

    @Override
    public ArrayList<Integer> call() throws Exception {
        // TODO Auto-generated method stub
        ArrayList<Integer> doubledList = new ArrayList<>();
        for (int number : list) {
            doubledList.add(number * 2);
        }
        return doubledList;
        // throw new UnsupportedOperationException("Unimplemented method 'call'");
    }
} 


class HelloWorldPrinter extends Thread{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Hello World " + Thread.currentThread().getName());
        // super.run();
    }
}

class Sorter implements Callable<ArrayList<Integer>>{
    ArrayList<Integer> listToSort;

    public Sorter(ArrayList<Integer> list){
        this.listToSort = list;
    }

    public ArrayList<Integer> getSubArray(ArrayList<Integer> list, int start, int end){
        ArrayList<Integer> halflist = new ArrayList<>();
        for(int i = start; i <= end; i++){
            halflist.add(list.get(start));
        }
        return halflist;
    }

    @Override
    public ArrayList<Integer> call() throws InterruptedException, ExecutionException {
        // TODO Auto-generated method stub
        if(listToSort.size() == 1) return listToSort;
        int mid = listToSort.size() / 2;
        ArrayList<Integer> leftHalfToSort = getSubArray(listToSort, 0, mid);
        ArrayList<Integer> rightHalfToSort = getSubArray(listToSort, mid+1, listToSort.size()-1);
        
        ExecutorService es = Executors.newCachedThreadPool();

        Sorter leftSorter = new Sorter(leftHalfToSort);
        Sorter rightSorter = new Sorter(rightHalfToSort);

        Future<ArrayList<Integer>> leftSortedFuture = es.submit(leftSorter);
        Future<ArrayList<Integer>> rightSortedFuture = es.submit(rightSorter);

        ArrayList<Integer> leftSortedList = leftSortedFuture.get();
        ArrayList<Integer> rightSortedList = rightSortedFuture.get();

        return merge(leftSortedList, rightSortedList);
    }
    
    public ArrayList<Integer> merge(ArrayList<Integer> A, ArrayList<Integer> B){
        int i = 0, j = 0;
        ArrayList<Integer> mergedList = new ArrayList<>(); 
        while (i < A.size() && j < B.size()) {

            if (A.get(i) <= B.get(j)) {
                mergedList.add(A.get(i));
                i++;
            } else {
                mergedList.add(B.get(j));
                j++;
            }
        }

        while (i < A.size()) {
            mergedList.add(A.get(i++));
        }

        while (j < B.size()) {
            mergedList.add(B.get(j++));
        }

        return mergedList;
    }
}

class Value{
    int val;
    public Value(int num){
        this.val = num;
    }
}

class Adder implements Callable<Void>{
    Value num;
    Lock lock;
    public Adder(Value v, Lock lock){
        this.num = v;
        this.lock = lock;
    }
    @Override
    public Void call() throws Exception {
        // TODO Auto-generated method stub
        for(int i = 0; i < 10000; i++ ) {
            lock.lock();
            num.val += i;
            lock.unlock();;
        }
        return null;
    }
}

class Subtracter implements Callable<Void>{
    Value num;
    Lock lock;
    public Subtracter(Value v, Lock lock){
        this.num = v;
        this.lock = lock;
    }
    @Override
    public Void call() throws Exception {
        // TODO Auto-generated method stub
        for(int i = 0; i < 10000; i++ ) {
            lock.lock();
            num.val -= i;
            lock.unlock();
        }
        return null;
    }
}



public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // System.out.println("Hello world");

        // String threadName = Thread.currentThread().getName();
        // System.out.println("HELLO WORLD " + threadName);

        // HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        // helloWorldPrinter.start();

        // HelloWorldPrinter helloWorldPrinter1 = new HelloWorldPrinter();
        // helloWorldPrinter1.run();

        // NumberPrinter numberPrinter = new NumberPrinter();
        // numberPrinter.start();

        // NumberPrinter numberPrinter1 = new NumberPrinter();
        // numberPrinter1.start();

        // for(int i = 1; i < 101; i++){
        //     NumberPrinter numberPrinter = new NumberPrinter(i);
        //     numberPrinter.start();
        // }
        // for(int i = 1; i < 101; i++){
        //     NumberPrinter task = new NumberPrinter(i);
        //     Thread th = new Thread(task);
        //     th.start();
        // }

        // ExecutorService es = Executors.newFixedThreadPool(10);
        // for(int i=1; i <= 100; i++){
        //     es.submit(new NumberPrinterV2(i));
        // }

        // ArrayList<Integer> list = new ArrayList<>();
        // for (int i = 10; i >= 0; i--) {
        //     list.add(i);
        // }
        // Sorter task =  new Sorter(list);
        // // ExecutorService 
        // Future<ArrayList<Integer>> future = es.submit(task);

        // try {
        //     List<Integer> doubledList = future.get();
        //     System.out.println("Original list: " + list);
        //     System.out.println("Doubled list: " + doubledList);
        // } catch (InterruptedException | ExecutionException e) {
        //     e.printStackTrace();
        // } finally {
        //     es.shutdown();
        // }

        Lock lock = new ReentrantLock();

        Value v = new Value(0);
        Adder taskAdd = new Adder(v, lock);
        Subtracter taskSubtract = new Subtracter(v, lock);

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> adderFuture = es.submit(taskAdd);
        Future<Void> subtracterFuture = es.submit(taskSubtract);

        adderFuture.get();
        subtracterFuture.get();

        System.out.println(v.val);
    }
}