package threads.producerconsumer;

public class ProducerConsumerRunner {
    public static void main(String[] args) {
        SingleBuffer buffer = new SingleBuffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        
        Thread producerThread = new Thread(producer,"Producer Thread");
        Thread consumerThread = new Thread(consumer,"Consumer Thread");
        producerThread.start();
        consumerThread.start();
    }
}