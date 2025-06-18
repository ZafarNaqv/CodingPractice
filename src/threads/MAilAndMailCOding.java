package threads;

public class MAilAndMailCOding {
    // Implement a program that prints the numbers 1 .. 100 in ascending order. Use two
    // threads, one thread printing even numbers, the other printing odd numbers only.
    
    
    public static void main(String[] args) {
        boolean lock =false;
        
        Thread threadEven = new Thread(() -> {
            for(int i = 2; i <= 20; i=i+2) {
                    System.out.println(i);
                
            }
        });
        
        Thread oddThread = new Thread(() -> {
            for(int i = 1; i <= 20; i=i+2) {
                    System.out.println(i);
            }
        });
        threadEven.start();
        oddThread.start();
        
    }
}