package threads.fizzbuzz;

public class SharedCounter {
    private int counter = 1;
    
    public int getCounter() {
        return counter;
    }
    
    public void incrementCounter() {
        counter++;
    }
}