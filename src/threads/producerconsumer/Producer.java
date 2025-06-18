package threads.producerconsumer;

import java.util.Objects;

public class Producer implements Runnable{
    SingleBuffer buffer;
    int currentCount;
    public Producer(SingleBuffer buffer) {
        this.buffer = buffer;
        currentCount = 0;
    }
    @Override
    public void run() {
        synchronized (buffer) {
            try {
                while(currentCount<= SingleBuffer.MAX_LIMIT) {
                    while(!Objects.isNull(buffer.getBuffer())){
                        buffer.wait();
                    }
                    buffer.setBuffer(currentCount);
                    System.out.printf("Producer: %d \n", buffer.getBuffer());
                    currentCount++;
                    buffer.notifyAll();
                }
                System.out.println("Producer task finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}