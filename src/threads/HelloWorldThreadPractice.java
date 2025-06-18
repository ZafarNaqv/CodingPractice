package threads;

public class HelloWorldThreadPractice implements Runnable {
    static int counter = 0;
    static final Object lock = new Object();
    
    public static void main(String[] args) {
        Thread helloThread = new Thread(new HelloWorldThreadPractice(),"hello");
        Thread worldThread = new Thread(new HelloWorldThreadPractice(),"world");
        helloThread.start();
        worldThread.start();
    }
    
    @Override
    public void run() {
        do {
            if (Thread.currentThread().getName().equals("hello") &&counter%2==0) {
            synchronized (lock) {
                    System.out.println("Hello");
                    counter++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            
            if (Thread.currentThread().getName().equals("world") &&counter%2==1) {
                synchronized (lock) {
                    System.out.println("World");
                    counter++;
                    lock.notify();
                }
            }
        }while(counter < 10);
    }
}