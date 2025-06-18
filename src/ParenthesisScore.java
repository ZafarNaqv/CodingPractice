import java.util.Stack;

public class ParenthesisScore {
    public static void main(String[] args) {
        System.out.println(new ParenthesisScore().scoreOfParentheses("()()"));//11
    }
    
    public int scoreOfParentheses(String s) {
        Stack<Integer> resultStack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                resultStack.push(0);
            }else{
                int stackTop = resultStack.peek();
                if(stackTop == 0) {
                    resultStack.pop();
                    resultStack.push(1);
                }else{
                    int result = 0;
                    while(!resultStack.isEmpty() && resultStack.peek() != 0) {
                        result += resultStack.pop();
                        
                    }
                    resultStack.pop();
                    resultStack.push(result*2);
                }
            }
        }
        int sum=0;
        while(!resultStack.isEmpty()) {
            sum += resultStack.pop();
        }
        
        return sum;
    }
}