import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis runner = new ValidParenthesis();
        System.out.println(runner.isValid("(])"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char currentChar: s.toCharArray()){
            if(currentChar== '(' || currentChar== '[' || currentChar== '{'){
                stack.add(currentChar);

            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if((currentChar==')' && stack.peek()=='(') || (currentChar=='}' && stack.peek()=='{') || (currentChar==']' && stack.peek()=='[')){
                    stack.pop();
                }else{
                    return false;
                }

            }

        }
        return stack.isEmpty();
    }
}
