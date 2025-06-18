import java.util.*;

public class RecursionPractice {
    HashSet<Integer> result = new HashSet<>();
    private int index = 0;
    final int MOD = 1_000_000_007;
    private int goodNumbers= 0;
    public static void main(String[] args) {
        RecursionPractice runner = new RecursionPractice();
        //System.out.println(runner.sum(5));
        
      //  System.out.println(runner.totalNumbersNonRecursive(new int[]{1,2,3,4}));
        //  System.out.println("\n"+runner.totalNumbers(new int[]{8,4,8,0,7,2,6,9,3,2}));
      //  System.out.println(runner.kthCharacter(5));
        
       // System.out.println(runner.reverseParentheses("(u(love)i)"));
        
        System.out.println(runner.countGoodNumbersOptmised(50));
    }
    //Give sum from 1 to n
    public int sum(int n){
        if(n==1){
            return 1;
        }
        return sum(n-1)+n;
    }
    
    //Give total unique 3 digit numbers
    public int totalNumbersNonRecursive(int[] digits) {
        int num;
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && i != k) {
                        num = digits[k]*100 + digits[i]*10 + digits[j];
                        if(num>99 && num<1000 && num%2==0){
                            //System.out.println(num);
                            result.add(num);
                        }
                    }
                    
                }
            }
        }
        
        return result.size();
    }
    
    
    public int totalNumbers(int[] digits) {
        boolean[] used= new boolean[digits.length];
        Set<Integer> results = new HashSet<>();
        int[] current = new int[3];
        Arrays.sort(digits);
        recursiveBackTrack(digits,current,used,0,results);
        return results.size();
    }
    
    private void recursiveBackTrack(int[] digits, int[] current,boolean[] used, int currentSize,Set<Integer> results){
        if (currentSize == 3) {
            if (current[2] % 2 == 0) {
                addToResult(current, results);
            }
            return;
        }
        boolean[] seenArr = new boolean[1000];
        for(int i = 0;i<digits.length;i++){
            if(used[i]){
                continue;
            }
            if (currentSize == 0 && digits[i] == 0) {
                continue; // leading zero — skip
            }
            if (seenArr[digits[i]])
                continue; // SKIP duplicates at this level
            
            seenArr[digits[i]] = true;
            
            used[i]= true;
            current[currentSize] = digits[i];
            recursiveBackTrack(digits,current,used,currentSize+1,results);
            used[i]=false;
            
        }
        
        
        
    }
    
    private void addToResult(int[] current,Set<Integer> results){
        results.add(current[0]*100 + current[1]*10 + current[2]);
    }
    
    //https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/?envType=problem-list-v2&envId=recursion
    public char kthCharacter(int k) {
        String input = "a";
        input = playGame(input,k);
        return input.charAt(k-1);
    }
    
    private String playGame(String input, int k) {
        if(input.length()>=k){
            return input;
        }
        input = String.valueOf(generateNewString(new StringBuilder(input)));
        return playGame(input, k);
    }
    
    private StringBuilder generateNewString(StringBuilder input) {
        StringBuilder sb = new StringBuilder(input);
        char[] newString = new char[input.length()];
        int index = 0;
        for(char c : input.toString().toCharArray()){
            if(c=='z'){
                newString[index]='a';
            }else{
                newString[index]= (char) (c+1);
            }
            index++;
        }
        return sb.append(newString);
        
    }
    
    /*Given a string s containing letters and parentheses, reverse the characters
    inside each pair of matching parentheses, starting from the innermost one.*/
    /*Input: s = "(abcd)"
    Output: "dcba"*/
    public String reverseParentheses(String s) {
        StringBuilder result = new StringBuilder();
        while(index<s.length()){
            
            if(s.charAt(index)=='('){
                index++;
                String reversedString = reverseParentheses(s);
                result.append(reversedString);
            }else if(s.charAt(index)==')'){
                index++;
                return result.reverse().toString();
            }else{//Normal alphabet
                result.append(s.charAt(index));
                index++;
            }
        }
        return result.toString();
    }
    
/*
    A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
    
    For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.*/
    public int countGoodNumbers(long n) {
        return countGoodNumbersUnOptimised(n,0);
    }
    
    private int countGoodNumbersUnOptimised(long n, int currentNum ) {
        int length = String.valueOf(currentNum).length();
        char[] currentNumChar = String.valueOf(currentNum).toCharArray();
        boolean isGoodNumber = true;
        if(length>n){
            return goodNumbers;
        }
        for(int index=0;index<length;index++){
            int number = currentNumChar[index] - '0';
            if(index%2==0){//Even Index
                if(number % 2 != 0){
                    isGoodNumber = false;
                    break;
                }
            }else{
                Set<Integer> primes = Set.of(2, 3, 5, 7);
                if (!primes.contains(number)) {
                    isGoodNumber = false;
                    break;
                }
            }
        }
        if(isGoodNumber){
            goodNumbers++;
        }
        currentNum++;
        return countGoodNumbersUnOptimised(n,currentNum);
    }
    
    public int countGoodNumbersOptmised(long n) {
        return (int) countGoodNumbersOptimised(0, n);
    }
    
    private long  countGoodNumbersOptimised(int pos, long n) {
        long goodNumbers = 0;
        if(pos==n){
            return 1;
        }
        if(pos%2==0){
            Set<Integer> allowedDigits= Set.of(0,2,4,6,8);
            goodNumbers = (allowedDigits.size() * countGoodNumbersOptimised(pos + 1, n)) % MOD;
        }else{
            Set<Integer> allowedPrimeDigits= Set.of(2,3,5,7);
            goodNumbers = (allowedPrimeDigits.size() * countGoodNumbersOptimised(pos + 1, n)) % MOD;
            
        }
        
        return goodNumbers % MOD;
    }
    
}