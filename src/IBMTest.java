import java.util.*;

public class IBMTest {
    public static void main(String[] args) {
  /*  List<String> products = List.of("duel","speed","dule","cars");
    List<String> queries = List.of("spede","deul");
    System.out.println(getProductMatches(products,queries));
    System.out.println(getProductMatchesMySolution(products,queries));*/
        System.out.println(getMinOperations("00000000",3,2));

    }
    public static List<List<String>> getProductMatches(List<String> products, List<String> queries) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String product : products) {
            String sorted = sortString(product);
            anagramMap.computeIfAbsent(sorted, k -> new ArrayList<>()).add(product);
        }
        List<List<String>> result = new ArrayList<>();
        
        for(String query : queries) {
            String sortedQuery = sortString(query);
            List<String> matches = anagramMap.getOrDefault(sortedQuery, new ArrayList<>());
            List<String> sortedMatches = new ArrayList<>(matches);
            Collections.sort(sortedMatches);
            result.add(sortedMatches);
        }
        return result;
        
    }
    
    private static String sortString(String product) {
       char[] chars = product.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    
    public static List<List<String>> getProductMatchesMySolution(List<String> products, List<String> queries) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for (String product : products) {
            String sorted = sortStringLexigraphically(product);
           // anagramMap.computeIfAbsent(sorted,k -> new ArrayList<>()).add(product);
            anagramMap.putIfAbsent(sorted, new ArrayList<>());
            anagramMap.get(sorted).add(product);
        }
        List<List<String>> result = new ArrayList<>();
        for (String query : queries) {
            String sortedQuery = sortStringLexigraphically(query);
            if(anagramMap.containsKey(sortedQuery)) {
                result.add(anagramMap.get(sortedQuery));
            }
        }
        return result;
    }
    
    private static String sortStringLexigraphically(String product) {
        char[] chars = product.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    
    public static int getMinOperations(String s, int m, int k) {int minOperations = Integer.MAX_VALUE;
        return computeRecursive(s,m,k,0,Integer.MAX_VALUE,0);
    }
    
    private static int computeRecursive(String s, int m, int k, int startIndex, int minOperations,int currentOperations) {
        if (!s.contains("0".repeat(m))) {
            return Math.min(minOperations, currentOperations);
        }
        for(int i=startIndex; i<=s.length()-m; i++) {
            boolean consecutiveZeros = true;
            for(int j=i; j<i+m; j++) {
                if(s.charAt(j) != '0') {
                    consecutiveZeros = false;
                    break;
                }
            }
            if(consecutiveZeros) {
                String modified = replaceRangeWithChar(s, i, i + k, '1');
                int result = computeRecursive(modified, m, k, i + k, minOperations, currentOperations + 1);
                minOperations = Math.min(minOperations, result);
            }
        }
        return minOperations;
    }
    
    private static String replaceRangeWithChar(String str, int start, int end, char replacementChar) {
        if (start < 0 || end > str.length() || start > end) {
            throw new IllegalArgumentException("Invalid start or end indices");
        }
        StringBuilder replacement = new StringBuilder();
        for (int i = start; i < end; i++) {
            replacement.append(replacementChar);
        }
        return str.substring(0, start) + replacement + str.substring(end);
    }
    
}