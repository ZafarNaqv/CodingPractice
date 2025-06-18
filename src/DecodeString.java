import java.util.Stack;

public class DecodeString {
    private int index = 0;
    public static void main(String[] args) {
        DecodeString runner = new DecodeString();
       // String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String s = "3[a2[c]]";
        System.out.println(runner.decodeString(s));
        System.out.println(runner.recursiveSolver(s));
    }
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ']'){
                while(!stack.isEmpty() && stack.peek() != '['){
                    currentString.insert(0, stack.pop());
                }
                stack.pop(); // pops [
                StringBuilder num = new StringBuilder();
                while(!(stack.isEmpty())){
                    if(Character.isDigit(stack.peek())){
                        num.insert(0, stack.pop());
                    }else{
                        break;
                    }
                }
                int replicationFactor = Integer.parseInt(String.valueOf(num));
                pushStringToStack(stack,currentString.toString().repeat(replicationFactor));
                currentString.setLength(0);
  
                
            }else{
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0, stack.pop());
        }
        
        
        return res.toString();
    }
    
    private void pushStringToStack(Stack<Character> stack, String currentString) {
        for(char c : currentString.toCharArray()){
            stack.push(c);
        }
    }
    
   // String s = "3[a2[c]]";
    private String recursiveSolver(String s){
        StringBuilder result = new StringBuilder();
        while(index < s.length()){
            StringBuilder num = new StringBuilder();
            if(Character.isDigit(s.charAt(index))){
                while(Character.isDigit(s.charAt(index))) {
                    num.append( s.charAt(index));
                    index++;
                }
                index++; // ignores [
                String decodedString = recursiveSolver(s);
                int replicationFactor = Integer.parseInt(String.valueOf(num));
                for(int i = 0;i < replicationFactor;i++){
                    result.append(decodedString);
                }
            } else if (s.charAt(index)==']') {
                index++;
                return result.toString();
            
            }else{//Normal alphabet;
                result.append(s.charAt(index));
                index++;
            }
            
        }
        return result.toString();
    }
}