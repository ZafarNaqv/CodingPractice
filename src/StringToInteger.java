public class StringToInteger {
    
    
    public static void main(String[] args) {
        StringToInteger stoI = new StringToInteger();
        System.out.println(stoI.myAtoi("   +0 123")); //"0-1
    }
    public int myAtoi(String s) {
        s = s.trim();
        int result = 0;
        int index = 0;
       boolean isNegative = false;
       boolean firstNonZeroDigitSeen = false;
       for(char c: s.toCharArray()) {
           if(index==0 && c!='+' && c!='-' && !Character.isDigit(c)) {
               break;
           }
           if(c == '+' || c == '-'){
               if(index != 0){
                   break;
               }
           }
           if(c== '-'){
               isNegative = true;
           }
           if(!firstNonZeroDigitSeen && c=='0'){
               index++;
               continue;
           }
          
           if(!Character.isDigit(c)){
               if(firstNonZeroDigitSeen || Character.isLetter(c) || Character.isWhitespace(c)){
                   break;
               }
           }else {
               if (result > (Integer.MAX_VALUE - Character.getNumericValue(c)) / 10) {
                   return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
               }
               result = result * 10 + Character.getNumericValue(c);
               firstNonZeroDigitSeen = true;
           }
           index++;
       }
       return isNegative ? -result : result;
    }
    
}