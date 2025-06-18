package threads;

public class PrintArray implements Runnable {
    static int[] array = {2,7,3,8};
    static int counter = 0;
    static final Object lock = new Object();
    
    public static void main(String[] args) {
        Thread thread0 = new Thread(new PrintArray(),"thread0");
        Thread thread1 = new Thread(new PrintArray(),"thread1");
        Thread thread2 = new Thread(new PrintArray(),"thread2");
        Thread thread3 = new Thread(new PrintArray(),"thread3");
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
    @Override
    public void run() {
        while(true) {
            synchronized (lock) {
                if(counter == array.length) {
                    lock.notifyAll();
                    return;
                }
                int threadIndex = Integer.parseInt(Thread.currentThread().getName().split("thread")[1]);
                while(threadIndex != counter) { //wait while its not its turn
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(array[threadIndex]);
                counter++;
                // Notify all waiting threads to check again
                lock.notifyAll();
            }
        }
    }
}