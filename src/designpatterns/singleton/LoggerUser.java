package designpatterns.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class LoggerUser {
    public static void main(String[] args) throws InterruptedException {
       /* SingletonLogger logger = SingletonLogger.getLogger();
        SingletonLogger anotherLogger = SingletonLogger.getLogger();
        logger.log("Yoyo Honey Singh");
        anotherLogger.log("Another logger");
        if(logger.equals(anotherLogger)){
            System.out.println("Loggers are equal");
        }else{
            System.out.println("Loggers are not equal");
        }
        */
        multiThreadedTest();
    }
    
    public static void multiThreadedTest()  throws InterruptedException{
      final int THREAD_COUNT = 100;
      Set<Integer> hashCodeSet = Collections.synchronizedSet(new HashSet<>());
      CountDownLatch readyLatch = new CountDownLatch(THREAD_COUNT);
      CountDownLatch startLatch = new CountDownLatch(1);
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                readyLatch.countDown();
                try {
                    startLatch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                SingletonLogger logger = SingletonLogger.getLogger();
                hashCodeSet.add(logger.hashCode());
            }).start();
        }
        readyLatch.await();
        startLatch.countDown();
        Thread.sleep(1000);
        System.out.println("Number of distinct hash codes: " + hashCodeSet.size());
    }
}