import java.util.LinkedList;
import java.util.Queue;

public class TomTomTestPractice {
    public static void main(String[] args) {
        TomTomTestPractice runner = new TomTomTestPractice();
        int [] T ={10000};
        System.out.println(runner.solution(T));
    }
    public int solution(int[] T) {
        Queue<Task> workQ = new LinkedList();
        int client=0;
        for(int i:T){
            workQ.add(new Task(client++,i));
        }


        LinkedList<Integer> workSchedule = new LinkedList();

        while(!workQ.isEmpty()){
            Task currentTask = workQ.poll();
            currentTask.remainingTime--;
            workSchedule.add(currentTask.clientId);
            if(currentTask.remainingTime!=0){
                workQ.add(currentTask);
            }
        }

        int totalTime = 0;
       for(int i =0;i<client;i++){
           totalTime+= workSchedule.lastIndexOf(i)+1;
       }
        return (int) (totalTime % Math.pow(10,9));
    }

    // Helper class to represent an task
    static class Task {
        int clientId;
        int remainingTime;

        public Task(int clientId, int remainingTime) {
            this.clientId = clientId;
            this.remainingTime = remainingTime;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "clientId=" + clientId +
                    ", remainingTime=" + remainingTime +
                    '}';
        }
    }
}
