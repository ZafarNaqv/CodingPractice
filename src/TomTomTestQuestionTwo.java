import java.util.LinkedList;
import java.util.Queue;

public class TomTomTestQuestionTwo {
    public static void main(String[] args) {
        TomTomTestQuestionTwo runner = new TomTomTestQuestionTwo();
        int [] T ={3,2,1};
        System.out.println(runner.solution(T));
    }
    public int solution(int[] T) {
        if(T.length==1){
            return T[0];
        }

        Queue<Task> queue = new LinkedList<>();

        // Add all task to the queue
        for (int i = 0; i < T.length; i++) {
            queue.add(new Task(i, T[i]));
        }

        int totalTime = 0; // Elapsed time
        int totalWaitingTime = 0;

        while (!queue.isEmpty()) {
            Task current = queue.poll();
            totalTime++;
            current.remainingTime--;

            // If the item is completed
            if (current.remainingTime == 0) {
                totalWaitingTime += totalTime;
            } else {

                queue.add(current);
            }
        }

        return (int) (totalWaitingTime % Math.pow(10,9));
    }

    // Helper class to represent an task
    static class Task {
        int clientId;
        int remainingTime;

        public Task(int clientId, int remainingTime) {
            this.clientId = clientId;
            this.remainingTime = remainingTime;
        }
    }
}
