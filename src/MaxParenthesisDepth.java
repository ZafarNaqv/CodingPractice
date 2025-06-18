import java.util.Stack;

public class MaxParenthesisDepth {
    public static void main(String[] args) {
        System.out.println(new MaxParenthesisDepth().maxDepth("(1)+((2))+(((3)))"));
    }
    
    
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
            
            }
        }
        return 0;
    }
}