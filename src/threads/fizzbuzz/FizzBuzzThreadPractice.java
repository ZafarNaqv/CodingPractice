package threads.fizzbuzz;

public class FizzBuzzThreadPractice {
   
    
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        FizzBizzWorkerThread fizzThread = new FizzThread("FizzThread",sharedCounter);
        FizzBizzWorkerThread buzzThread = new BuzzThread("BuzzThread",sharedCounter);
        FizzBizzWorkerThread fizzBuzzThread = new FizzBuzzThread("FizzBuzzThread",sharedCounter);
        FizzBizzWorkerThread numberThread = new NumberThread("NumberThread",sharedCounter);
        
        
        new Thread(fizzThread).start();
        new Thread(buzzThread).start();
        new Thread(fizzBuzzThread).start();
        new Thread(numberThread).start();
    }
  
}