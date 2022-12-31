package E3;

import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        myThread.start();

        for (int i = 0; i < 5; i++) {
            Thread.yield();
            System.out.println("Thread started " + Thread.currentThread().getName());
        }
        System.out.println("Thread ended " + Thread.currentThread().getName());

    }

}

class MyThread extends Thread{

    volatile public boolean keepRunning = true;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread.yield();
            System.out.println("Thread started " + getName());
        }
        System.out.println("Thread ended " + getName());
    }

}
