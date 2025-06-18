import java.util.Stack;

public class ValidPalindrome {
    public static void main(String[] args) {
       // System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindromeStack("0P"));
    }
    
    public static boolean isPalindromeStack(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString().toLowerCase().contentEquals(sb.reverse().toString().toLowerCase());
    }

    public static boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        StringBuilder result = new StringBuilder();
        for(char c: s.toLowerCase().toCharArray()){
            if(Character.isLetterOrDigit(c)){
                result.append(c);
            }
        }
        StringBuilder original = new StringBuilder(result.toString());

        String reverse = result.reverse().toString();
       // System.out.println("Reverse   : " + reverse); // Should print "cba"
        //System.out.println("original  : " + original);
        return reverse.contentEquals(original);
    }
}