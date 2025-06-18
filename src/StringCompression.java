public class StringCompression {
    public static void main(String[] args) {
        String input = "abcc";
        System.out.println(new StringCompression().compress(input.toCharArray()));
    }
    
    public int compress(char[] chars) {
      int readIndex = 0;
      int writeIndex = 0;
      if(chars.length == 0){
          return 0;
      }
      int occurrence =0;
      while(readIndex < chars.length) {
          char currentChar = chars[readIndex];
          while (readIndex < chars.length && chars[readIndex] == currentChar) {
              readIndex++;
              occurrence++;
          }
          chars[writeIndex++] = currentChar;
          if (occurrence > 1) {
              for (char digit : String.valueOf(occurrence).toCharArray()) {
                  chars[writeIndex++] = digit;
              }
          }
          occurrence = 0;
      }
      return writeIndex;
    }
    
    
}