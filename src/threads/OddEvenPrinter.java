package threads;

public class OddEvenPrinter implements Runnable{
    final Object lock;
    static int counter=1;
    
    public OddEvenPrinter(Object lock) {
        this.lock = lock;
    }
    
    public static void main(String[] args) {
        Object obj = new Object();
        Thread oddThread = new Thread(new OddEvenPrinter(obj ),"odd");
        Thread evenThread = new Thread(new OddEvenPrinter(obj ),"even");
        oddThread.start();
        evenThread.start();
    }
    
    @Override
    public void run() {
        while (counter <= 20) {
            if (Thread.currentThread().getName().equals("even") && counter % 2 == 0) {
                synchronized (lock) {
                    System.out.println(counter);
                    counter++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (Thread.currentThread().getName().equals("odd") && counter % 2 == 1) {
                synchronized (lock) {
                    System.out.println(counter);
                    counter++;
                    lock.notify();
                }
            }
        }
    }
}