package com.houyao.thread.futureAndCallable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Test implements Runnable{
    @Override
    public void run(){
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        ExecutorService executorService = Executors.newCachedThreadPool();
        //        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<String>> futureList = new ArrayList<Future<String>>();
        // 此线程池运行5个线程
        for (int i = 0; i < 5; i++) {
            final int index = i;
            // 使用 submit 方法 和 execute 方法的区别是，execute 方法没有返回值，而 submit 方法有返回值。
            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("Thread-" + index + "-begin-" + sf.format(new Date()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread-" + index + "-end-" + sf.format(new Date()));
                    return "index-" + index;
                }

            });
            futureList.add(future);
        }
        // future.get() 是阻塞执行的，所以获取值要在线程都启动之后，再获取
        for (Future<String> future : futureList) {
            try {
                System.out.println("返回值" + future.get()); // 获取线程返回值
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Test()).start();
    }
}
