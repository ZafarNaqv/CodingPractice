package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class OddEvenPrinterES {
    public static void main(String[] args) {
        ExecutorService  executorService = Executors.newFixedThreadPool(2);
        IntStream.range(1,21).forEach(i -> {
            CompletableFuture<Integer> oddCompletableFuture = CompletableFuture.completedFuture(i).
                    thenApplyAsync(x->{
                        if(x%2!=0){
                            System.out.println(x);
                        }
                        return x;
                    },executorService);
            oddCompletableFuture.join();
            
            CompletableFuture<Integer> evenCompletableFuture = CompletableFuture.completedFuture(i).
                    thenApplyAsync(x->{
                        if(x%2==0){
                            System.out.println(x);
                        }
                        return x;
                    },executorService);
            evenCompletableFuture.join();
        });
        executorService.shutdown();
    }
}