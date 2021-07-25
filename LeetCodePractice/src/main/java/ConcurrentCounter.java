/**
 * Java多线程编程 案例
 * https://www.geeksforgeeks.org/different-approaches-to-concurrent-programming-in-java/
 *
 * 关键：
 *  1. 干活的Class implements Runnable + run()
 *  2. ExecutorService -- 线程池 + execute(Runnable class)
 * */

import java.util.concurrent.*;

public class ConcurrentCounter implements Runnable{
    private final MainApp mainApp;
    private final int loopLimit;
    private final String task;

    // Constructor to get a reference to the main class
    public ConcurrentCounter (MainApp mainApp, int loopLimit, String task){
        this.mainApp = mainApp;
        this.loopLimit = loopLimit;
        this.task = task;
    }

    // Prints the thread name, task number and the value of counter
    //  Calls pause method to allow multithreading to occur
    public void run(){
        for (int i = 0; i <loopLimit; i ++){
            System.out.println("Thread: " + Thread.currentThread().getName()
                    + " Counter: " + (i +1) + " Task: " + task);
            mainApp.pause(Math.random());
        }
    }
}

class MainApp{
    // Starts the threads. Pool size 2 means at any time
    //  there can only be two simultaneous threads
    public void startThread(){
        ExecutorService taskList = Executors.newFixedThreadPool(2);
        for (int i =0; i<5; i++){
            // Makes tasks available for execution.
            taskList.execute(new ConcurrentCounter(this, i+1, "task "+(i+1)));
        }
        // Shuts the thread that's watching to see if you have added new tasks.
        taskList.shutdown();
    }

    // Pause execution for a moment
    public void pause(double seconds){
        try{
            Thread.sleep(Math.round(1000.0 * seconds));
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    // Driver method
    public static void main(String[] args){
        new MainApp().startThread();
    }
}
