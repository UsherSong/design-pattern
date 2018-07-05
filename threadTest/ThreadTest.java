package com.gupaoedu.user.services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created  by songjh on 2018-07-05 05:58.
 */
public class ThreadTest {

    private ExecutorService executorService;
    private ScheduledExecutorService scheduledExecutorService;

    public void init() {
        System.out.println("----init----");

        executorService = Executors.newFixedThreadPool(1);
        scheduledExecutorService = Executors.newScheduledThreadPool(10);
    }


    public void test() {
        System.out.println("-----testBegin-----");
        for (int i = 0; i < 10; i++) {
            executorService.execute(new AsynTask(i, 0));
        }
    }

    class AsynTask implements Runnable {
        int retryCount;
        int i;

        public AsynTask(int i, int retryCount) {
            this.i = i;
            this.retryCount = retryCount;
        }

        @Override
        public void run() {
            boolean invokeResult = doProcess(i);
//            System.out.println(retryCount);
            if (!invokeResult && retryCount < 2) {
                retryCount++;
               // System.out.println("retryCount=" + retryCount);
                scheduledExecutorService.schedule(new AsynTask(i, retryCount), 10, TimeUnit.SECONDS);
            }

            if (invokeResult || retryCount >= 2) {
                doSomeThing(invokeResult, i, retryCount);
            }

        }
    }

    private void doSomeThing(boolean invokeResult, int i, int retryCount) {
        System.out.println("doSomeThing---"+Thread.currentThread().getName() +
                ",i=" + i +
                ",invokeResult=" + invokeResult +
                ",retryCount=" + retryCount);
    }

    private boolean doProcess(int i) {
        if (i % 2 == 0) {
//            System.out.println(Thread.currentThread().getName() +
//                    ",i=" + i +
//                    ",doProcess=" + true );

            return true;
        } else {
//        System.out.println(Thread.currentThread().getName() +
//                ",i=" + i +
//                ",doProcess=" + false );
            return false;
        }
    }

}
