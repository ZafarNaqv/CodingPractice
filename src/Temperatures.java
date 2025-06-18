import java.util.Scanner;

public class Temperatures {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int mintemp = Integer.MAX_VALUE;
        if(n==0){
            System.out.println(0);
        }else {
            for (int i = 0; i < n; i++) {
                int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
                if(Math.abs(t)==Math.abs(mintemp)){
                    if(t>mintemp){
                        mintemp = t;
                    }
                }else if(Math.abs(t)<Math.abs(mintemp)){
                    mintemp = t;
                }
            }

            System.out.println(mintemp);
        }

    }
}
