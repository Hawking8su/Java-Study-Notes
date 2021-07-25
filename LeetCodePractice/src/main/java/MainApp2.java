
import java.util.concurrent.*;

/**
 * Java多线程编程 案例
 * 改写：ConcurrentCounter class -- 用MainApp2做主程序
 * */

public class MainApp2 {

    // 主方法
    public void pause(){
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    // 设置线程池， 启动线程
    public void startThreads(){
        ExecutorService taskList = Executors.newFixedThreadPool(2);
        // 设置任务数
        int totalTask =5;
        // 启动任务
        for (int i =0; i < totalTask; i++){
            taskList.execute(new Counter(this));
        }
        taskList.shutdown();
    }
    // Driver method
    public static void main(String[] args) {
        new MainApp2().startThreads();
    }


}

// 创建一个类，继承Runnable接口，调用主方法

class Counter implements Runnable{
    private MainApp2 mainApp2 = null;

    Counter(MainApp2 mainApp2){
        this.mainApp2 = mainApp2;
    }

    @Override
    public void run() {
        System.out.println("Starting task");
        mainApp2.pause();
        System.out.println("Ending task");
    }
}
