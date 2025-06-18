import java.util.Scanner;

public class MiddleArray {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
       // String s = in.nextLine();
        String s = "I hate to Love you here";
        String[] words = s.split(" ");
        String result = "";
        if(words.length%2==1){
            result = words[words.length/2];
        }else{
            result = words[words.length/2-1] + words[words.length/2];
        }
        System.out.println(result);
    }
}
