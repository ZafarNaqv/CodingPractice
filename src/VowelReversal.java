import java.util.Set;

public class VowelReversal {
    public static void main(String[] args) {
        VowelReversal runner = new VowelReversal();
        System.out.println(runner.reverseVowels("IceCreAm"));
        System.out.println(runner.reverseVowels("IceCreAm"));
        System.out.println(runner.reverseVowels("IceCreAm"));
    }
    
    public String reverseVowels(String s) {
        int leftIndex = 0;
        int rightIndex = s.length()-1;
        if(s.length()==1){
            return s;
        }
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] chars = s.toCharArray();
        boolean leftVowelFound=false;
        boolean rightVowelFound = false;
        while(leftIndex<rightIndex){
            if(vowels.contains(chars[leftIndex])){
                leftVowelFound = true;
            }if(vowels.contains(chars[rightIndex])){
                rightVowelFound = true;
            }
            if(!leftVowelFound){
                leftIndex++;
            }
            if(!rightVowelFound){
                rightIndex--;
            }
            
            
            if(leftVowelFound && rightVowelFound){
                s = swapCharacters(s,leftIndex,rightIndex);
                leftIndex++;
                rightIndex--;
                leftVowelFound = false;
                rightVowelFound = false;
            }
            
        }
        return s;
    }
    
    private String swapCharacters(String s,int i,int j){
        StringBuilder mString = new StringBuilder(s);
        char temp = mString.charAt(i);
        mString.setCharAt(i,mString.charAt(j));
        mString.setCharAt(j,temp);
        return mString.toString();
    }
}