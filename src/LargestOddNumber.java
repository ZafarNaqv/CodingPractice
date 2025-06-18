public class LargestOddNumber {
    public static void main(String[] args) {
        System.out.println(new LargestOddNumber().largestOddNumber("7542351161"));
    }
    public String largestOddNumber(String num) {
        for(int j=num.length(); j>0; j--){
          if(num.charAt(j-1)%2!=0){
              return num.substring(0,j);
          }
        }
        return "";
    }
}