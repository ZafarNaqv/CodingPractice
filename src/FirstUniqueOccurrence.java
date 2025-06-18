//Given a string s, find the first non-repeating character in it and return its index.
// If it does not exist, return -1.
public class FirstUniqueOccurrence {
    int[] occurenceArr = new int[26];
    
    public static void main(String[] args) {
        FirstUniqueOccurrence runner = new FirstUniqueOccurrence();
        System.out.println(runner.firstUniqChar("leezlade"));
    }
    
    public int firstUniqChar(String s) {
        for(int i=0; i<s.length(); i++) {
            occurenceArr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (occurenceArr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
    
    
}