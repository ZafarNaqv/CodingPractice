public class FindAndReplace {
    public static void main(String[] args) {
        System.out.println(FindAndReplace.findAndReplaceString("HelloWorld HELLO, hello there!","hello","hi"));
    }

    public static String findAndReplaceString(String originalText,String findWord,String replaceWord){
       String [] words = originalText.split(" ");
       StringBuilder result = new StringBuilder();
       for(String word:words){
          if(word.equalsIgnoreCase(findWord)){
                if(word.equals(word.toUpperCase())){
                    result.append(replaceWord.toUpperCase());
                }else if(word.equals(word.toLowerCase())){
                    result.append(replaceWord.toLowerCase());
                }else{
                    result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase());
                }
          }else{
              result.append(word);
          }
          result.append(" ");
       }
       result.append("\b");
       return result.toString();
    }
}
