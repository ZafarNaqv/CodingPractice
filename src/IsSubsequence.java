public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("bb", "ahbgdc"));
    }
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;
        
        int i = 0;
        for (final char c : t.toCharArray())
            if (s.charAt(i) == c && ++i == s.length())
                return true;
        
        return false;
    }
}