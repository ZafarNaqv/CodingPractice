package threads;

public class OddEvenRunner implements Runnable {
    private  int counter = 0;
    
    
    public static void main(String[] args) {
        OddEvenRunner oddEvenRunner = new OddEvenRunner();

        Thread evenThread = new Thread(oddEvenRunner,"EvenThread");
        Thread oddThread = new Thread(oddEvenRunner,"OddThread");
        evenThread.start();
        oddThread.start();
    }

    
    
    @Override
    public void run() {
        try {
            if(Thread.currentThread().getName().equals("EvenThread")) {
                printEven();
            }else{
                printOdd();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public  void printEven() throws InterruptedException {
        synchronized (this) {
            String name = Thread.currentThread().getName();
            while (counter < 20) {
                while (counter % 2 != 0) {
                    wait();
                }
                if (counter >= 20) break; // 👈 avoid overshooting
                counter++;
                System.out.println(name + ": " + counter);
                notifyAll();
            }
        }
    }
    
    public  void printOdd() throws InterruptedException {
        synchronized (this) {
            String name = Thread.currentThread().getName();
            while (counter < 20) {
                while (counter % 2 == 0) {
                    wait();
                }
                if (counter >= 20) break; // 👈 avoid overshooting
                counter++;
                System.out.println(name + ": "+counter);
                notifyAll();
            }
        }
    }
    
  
}