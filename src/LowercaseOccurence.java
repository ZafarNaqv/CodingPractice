import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LowercaseOccurence {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String userInput = in.nextLine();
        String[] words = userInput.split(" ");
        HashMap<String, Integer> wordMap = new HashMap<>();
        for(String s :words){
            if(wordMap.containsKey(s)){
                Integer occurence = wordMap.get(s);
                wordMap.put(s,occurence+1);
            }else{
                wordMap.put(s,1);
            }
        }
        int repeated = 0;
        for(int count: wordMap.values()){
            if(count>1){
                repeated++;
            }
        }
        System.out.println(repeated);
    }


}
