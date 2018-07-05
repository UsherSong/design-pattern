package com.gupaoedu.user.services;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created  by songjh on 2018-07-05 05:58.
 */
public class ThreadTest {

    private ExecutorService executorService;
    private ScheduledExecutorService scheduledExecutorService;
    private Map<Integer,Boolean> failRecordCache = new ConcurrentHashMap<Integer,Boolean>();

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
            if (!invokeResult && retryCount < 2) {
                retryCount++;
                scheduledExecutorService.schedule(new AsynTask(i, retryCount), 10, TimeUnit.SECONDS);
            }
//            if (invokeResult) {
//                doSomeThing(invokeResult, i, retryCount);
//            }else if(retryCount==2 && failRecordCache.get(i)==null){
//                failRecordCache.put(i,true);
//                doSomeThing(invokeResult, i, retryCount);
//            }
//            System.out.println(cache);
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
            System.out.println(Thread.currentThread().getName() +
                    ",i=" + i +
                    ",doProcess=" + true );

            return true;
        } else {
        System.out.println(Thread.currentThread().getName() +
                ",i=" + i +
                ",doProcess=" + false );
            return false;
        }
    }

}
