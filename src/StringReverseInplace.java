public class StringReverseInplace {
    public static void main(String[] args) {
        StringReverseInplace runner = new StringReverseInplace();
        //char[] str = {'h', 'e', 'l', 'l', 'o'};
        char[] str = {'h', 'e', 'l', 'l', 'o','m'};
        runner.reverseString(str);
    }
    
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            swapElements(s, i, s.length - i - 1);
        }
        printCharacterArray(s);
    }
    
    private void swapElements(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    
    private void printCharacterArray(char[] s) {
        for(char c: s){
            System.out.print(c + " ");
        }
    }
}