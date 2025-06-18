package threads;

public class OddEvenRunnerPractice implements Runnable {
    int count =0;
    public static void main(String[] args) {
        OddEvenRunnerPractice runner = new OddEvenRunnerPractice();
        Thread eventhread = new Thread(runner,"EvenThread");
        Thread oddthread = new Thread(runner,"OddThread");
        eventhread.start();
        oddthread.start();
        
    }
    
    @Override
    public void run() {
        try {
            if(Thread.currentThread().getName().equals("EvenThread")){
                printEven();
            }else{
                printOdd();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void printEven() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized(this) {
            while (count < 20) {
                if (count % 2 != 0) {
                        count++;
                        System.out.printf("%s : %d\n", threadName, count);
                        notifyAll();
                }else{
                    wait();
                }
            }
        }
    }
    
    private void printOdd() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized(this) {
            while (count < 20) {
                if (count % 2 == 0) {
                        count++;
                        System.out.printf("%s : %d\n", threadName, count);
                        notifyAll();
                }else{
                    wait();
                }
            }
        }
    }
    
}