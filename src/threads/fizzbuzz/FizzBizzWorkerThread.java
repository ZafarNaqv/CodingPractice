package threads.fizzbuzz;

/*Thread Responsibilities:
FizzThread – prints "Fizz" if the number is divisible by 3 and not 5.

BuzzThread – prints "Buzz" if the number is divisible by 5 and not 3.

FizzBuzzThread – prints "FizzBuzz" if the number is divisible by both 3 and 5.

NumberThread (optional bonus) – prints the number if it's not divisible by 3 or 5.
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz

*/


public abstract class FizzBizzWorkerThread implements Runnable {
    protected String name;
    protected SharedCounter sharedCounter;
    
    public FizzBizzWorkerThread(String name, SharedCounter sharedCounter) {
        this.name = name;
        this.sharedCounter = sharedCounter;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                synchronized (sharedCounter) {
                    if(sharedCounter.getCounter()>30){
                        sharedCounter.notifyAll();
                        return;
                    }else{
                        runThreadLogic();
                    }
                }
                
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    protected abstract void runThreadLogic() throws InterruptedException;
}