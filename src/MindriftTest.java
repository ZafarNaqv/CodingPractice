import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MindriftTest {
    int result = 0;
    public static void main(String[] args) {
    List<String> strings = List.of("<<>>", "<><>", ">>");
    List<Integer> maxReplacements = List.of(0,0,2);
        //System.out.println(MindriftTest.balancedOrNot(strings, maxReplacements));
        System.out.println(countSameBitNumbers(10));
        System.out.println(new MindriftTest().recursiveCaller(10));
        
    }
    
    public static List<Integer> balancedOrNot(List<String> expressions, List<Integer> maxReplacements) {
        List<Integer> result = new ArrayList<>(expressions.size());
        
        for (int i = 0; i < expressions.size(); i++) {
            String expression = expressions.get(i);
            int maxReplacement = maxReplacements.get(i);
            Stack<Character> stack = new Stack<>();
            int currentReplacement = 0;
            boolean invalid = false;
            
            for (char c : expression.toCharArray()) {
                if (c == '<') {
                    stack.push(c);
                } else { // c == '>'
                    if (stack.isEmpty()) {
                        currentReplacement++;
                        if (currentReplacement > maxReplacement) {
                            result.add(0); // Not balanced
                            invalid = true;
                            break;
                        }
                    } else {
                        stack.pop();
                    }
                }
            }
            
            if (!invalid) {
                if (stack.isEmpty()) {
                    result.add(1); // Balanced
                } else {
                    result.add(0); // Not balanced: unmatched '<'
                }
            }
        }
        
        return result;
    }
    
    public static int countSameBitNumbers(int n) {
        String binaryRepresentation = Integer.toBinaryString(n);
        int maxLength = binaryRepresentation.length();
        String maxBinaryStringRepresentation = "1".repeat(maxLength);
        int onesCounts = Integer.bitCount(n);
        int maxNumber = Integer.parseInt(maxBinaryStringRepresentation,2);
        int result =0;
        for(int i=0;i<=maxNumber;i++){
            if(i==n){
                continue;
            }
            if(Integer.bitCount(i) == onesCounts){
                System.out.println(i + " Binary " + Integer.toBinaryString(i));
                result++;
            }
        }
        
        
        return result% (1000_000_007);
    }
    public int   recursiveCaller(int n){
        String binaryRepresentation = Integer.toBinaryString(n);
        int maxLength = binaryRepresentation.length();
        int targetOnes = Integer.bitCount(n);
        String paddedMinString = "0".repeat(maxLength);
        countBinaryRecursive(paddedMinString,targetOnes,n, 0,maxLength);
        return result% (1000_000_007);
    }
    //Integrate backtracking into it
    public  void countBinaryRecursive(String currentBinary, int targetOnes, int original, int index, int fullLength){
       
        
        int currentNumber = Integer.parseInt(currentBinary,2);
        int currentOnes = Integer.bitCount(currentNumber);
        boolean onesRemaining = true;
        
        if(currentOnes==targetOnes){
            onesRemaining = false;
        }
        
        if(currentNumber != original && currentOnes == targetOnes){
            System.out.println(currentNumber + " Binary " + currentBinary);
            result++;
            return;
        }
        
        if(index==fullLength){
            return;
        }
        
        if (onesRemaining) {
            StringBuilder oneBranch  = new StringBuilder(currentBinary);
            oneBranch .setCharAt(index, '1');
            countBinaryRecursive(oneBranch.toString(), targetOnes, original, index + 1, fullLength);
        }
        StringBuilder zeroBranch = new StringBuilder(currentBinary);
        zeroBranch.setCharAt(index, '0');
        countBinaryRecursive(zeroBranch.toString(), targetOnes, original, index + 1, fullLength);
    
        
    }
    
}