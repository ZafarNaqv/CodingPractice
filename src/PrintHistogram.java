import java.util.Scanner;

public class PrintHistogram {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        //int N = in.nextInt();
        int N = 2;
        int[] occurenceArr = {0,0,0,0,0,0,0,0,0,0};
        String sampleValue = in.nextLine();
        String[] userInput = sampleValue.split(" ");
        for(String count : userInput){
            occurenceArr[Integer.parseInt(count)]++;
        }


        StringBuilder result = new StringBuilder();
        for(int row = 1;row<10;row++){
            result.append(row).append(":").append("*".repeat(occurenceArr[row])).append("\n");
        }

        System.out.println(result);
    }
}
