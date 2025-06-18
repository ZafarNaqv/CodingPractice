package designpatterns.singleton;

import java.util.concurrent.CountDownLatch;

public class LoggerThread implements Runnable {
    private final CountDownLatch countDownLatch;
    
    public LoggerThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    
    @Override
    public void run() {
        try {
            countDownLatch.await();
            SingletonLogger logger = SingletonLogger.getLogger();
            logger.log("Using thread with name " + Thread.currentThread().getName()
                    + " | Logger hash: " + logger.hashCode());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}