import java.util.Locale;

public class DivideChars {

    public static void main(String[] args){
        DivideChars mainObj = new DivideChars();
        String text = "12345678abcdefghijklmnopqrstuvwxyz";
        System.out.println(mainObj.divideChars( text));
    }

    public static int divideChars(String text) {
        int digitCount=0;
        int letterCount=0;
        text = text.toUpperCase();
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)>=65 && text.charAt(i)<=91){
                letterCount++;
            }else{
                digitCount++;
            }
        }
        System.out.println("letterCount"+letterCount);
        System.out.println("digitCount"+digitCount);
        double result = (letterCount/(float)digitCount);
        System.out.println("result "+ result);

        return (int) Math.round(result);
    }
}
