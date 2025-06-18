package threads.producerconsumer;

import java.util.Objects;

public class Consumer implements Runnable{
    SingleBuffer buffer;
    int currentCount;
    public Consumer(SingleBuffer buffer) {
        this.buffer = buffer;
        currentCount = 0;
    }
    @Override
    public void run() {
        try {
            synchronized (buffer) {
                while (currentCount <= SingleBuffer.MAX_LIMIT) {
                    while (Objects.isNull(buffer.getBuffer())){
                        buffer.wait();
                    }
                    System.out.printf("Consumer: %d \n", buffer.getBuffer());
                    buffer.setBufferEmpty();
                    currentCount++;
                    buffer.notifyAll();
                }
                System.out.println("Consumer task is finished");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}