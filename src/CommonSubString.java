public class CommonSubString {
    public static void main(String[] args) {
        CommonSubString cs = new CommonSubString();
        System.out.println(cs.longestCommonPrefix(new String[]{"baab","bacb","b","cbc"}));
    }
    public String longestCommonPrefix(String[] strs) {
        String prefix =  strs[0];
        if(prefix.isEmpty()){
            return prefix;
        }
        for(String currentWord:strs){
            if(currentWord.contentEquals(prefix)){
                continue;
            }
            int smallerWordLength = Math.min(prefix.length(),currentWord.length());
            for(int i=0;i<smallerWordLength;i++){
                if(currentWord.charAt(i) != prefix.charAt(i)){
                    prefix = prefix.substring(0,i);
                    break;
                }
            }
            if(currentWord.length()<prefix.length()){
                prefix  = currentWord;
            }
            
        }
        return prefix;
    }
}