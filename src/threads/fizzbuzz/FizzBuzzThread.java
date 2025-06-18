package threads.fizzbuzz;

public class FizzBuzzThread extends FizzBizzWorkerThread{
    public FizzBuzzThread(String name, SharedCounter sharedCounter) {
        super(name, sharedCounter);
    }
    
    @Override
    protected void runThreadLogic() throws InterruptedException {
        synchronized (sharedCounter) {
            // Exit condition
            if (sharedCounter.getCounter() > 30) {
                sharedCounter.notifyAll(); // wake everyone
                return;
            }
            if(sharedCounter.getCounter() % 3 == 0 && sharedCounter.getCounter() % 5 == 0) {
                System.out.printf("%s: FizzBuzz\n", name);
                sharedCounter.incrementCounter();
                sharedCounter.notifyAll();
            }else {
                sharedCounter.wait();
            }
        }
    }
}