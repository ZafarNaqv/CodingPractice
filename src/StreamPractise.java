import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractise {
    public static void main(String[] args) {
        int[] nums = {2,4,7,3,7,3,6};
        int[] nums2 = {3,4,7,10};
        
        List<Integer> l1 = Arrays.asList(1,5,2,14,3);
        List<Integer> l2 = Arrays.asList(3,9,4,10,5);
        
        List<List<Integer>> list = Arrays.asList(l1, l2);
        String[] words = {"Banana","Ananas","Cat","Apple","Arrow"};
        String[] sentences = {"Sun is high","Boat is read","Pink is the new orange","I need to improve","I need help"};
        
       // System.out.println(new StreamPractise().partitionByDivisbility(nums));
       // System.out.println(new StreamPractise().removeEvenAndSquareRemaining(nums));
       // System.out.println(new StreamPractise().removeDuplicates(nums));
       // System.out.println(new StreamPractise().getMaximum(nums));
        //System.out.println(new StreamPractise().squareNumber(nums));/
      //  System.out.println(new StreamPractise().thresholdExceeded(nums));
       // System.out.println(new StreamPractise().maxEven(nums));
       // System.out.println(new StreamPractise().splitOnParity(nums));
       // System.out.println(new StreamPractise().average(nums));
      //  System.out.println(new StreamPractise().convertToWords(sentences));
        System.out.println(new StreamPractise().frequentOccurringCharacter(words));
       // System.out.println(new StreamPractise().upperCaseAWords(words));
        //System.out.println(new StreamPractise().wordLengthToWordMapper(words));
       // System.out.println(new StreamPractise().groupByFirstLetter(words));
       // System.out.println(new StreamPractise().moreThan5Characters(words));
      //  System.out.println(new StreamPractise().sortBasedOnLength(words));
    }
    
    private Map<Boolean,List<Integer>> splitOnParity(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.partitioningBy(num->num%2==0));
    }
    
    private int findMaximum(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }
    
    private int findMinimum(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }
    
    private int getSum(int[] nums) {
        return Arrays.stream(nums).reduce(0, (left, right) -> left + right);
    }
    
    private List<Integer> removeEvenAndSquareRemaining(int[] nums) {
        //Given a list of numbers, filter out even numbers and square the remaining ones
        return Arrays.stream(nums).filter(num -> num % 2 != 0).map(num->num*num).boxed().collect(Collectors.toList());
    }
    
    private Set<Integer> removeDuplicates(int[] nums) {
        //Collect a list of integers into a Set to remove duplicates.
        return Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
   
    private int getEvenSum(int[] nums) {
        // Find the sum of all even numbers in a list using reduce().
        
        return Arrays.stream(nums).filter(n->n%2==0).reduce(0, Integer::sum);
        
    }
    
    
    private int getMaximum(int[] nums) {
        // Find the maximum number in a list using reduce().
        
        return Arrays.stream(nums).reduce(-1, Integer::max);
        
    }
    
    
    
    private int getProductSum(List<List<Integer>> lists) {
        //sum them using l1[i] * l2[i] and then sum the product
        if (lists == null || lists.size() < 2) return 0;
        int minLength = Math.min(lists.get(0).size(), lists.get(1).size());
        IntStream.range(0,minLength).map(i->lists.get(0).get(i)*lists.get(1).get(i)).sum();
        return 0;
        
    }
    
    private List<String> upperCaseAWords(String[] words) {
        //Given a list of names, filter names that start with "A" and convert them to uppercase.
        return Arrays.stream(words).filter(word->word.startsWith("A")).map(String::toUpperCase).collect(Collectors.toList());
    }
    
    private List<String> sortBasedOnLength(String[] words) {
        //Sort a list of strings based on length.
        return Arrays.stream(words).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }
    
    private Map<Character,List<String>> groupByFirstLetter(String[] words) {
        //Given a list of strings, group them by their first letter.
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0)));
    }
    
    private Map<Boolean,List<Integer>> partitionByDivisbility(int[] nums) {
        // Given a list of integers, partition them into even and odd numbers.
        
        return Arrays.stream(nums).boxed().collect(Collectors.partitioningBy(num->num%2==0));
        
    }
    
    private Set<String> convertToWords(String[] sentenceList) {
        //Convert a list of sentences into a list of unique words.
        return Arrays.stream(sentenceList).flatMap(oneBigList->Arrays.stream(oneBigList.split(" "))).collect(Collectors.toSet());
    }
    
    
    
    
    private List<String> moreThan5Characters(String[] words) {
        //Given a list of names, return a list of names that have more than five characters, sorted alphabetically.
        return Arrays.stream(words).filter(word->word.length()>5).sorted().collect(Collectors.toList());
    }
    
    private Optional<Character> frequentOccurringCharacter(String[] words) {
        //Given a list of strings, return the most frequently occurring character across all strings.
        return Arrays.stream(words).flatMap(word -> word.chars().mapToObj(c -> (char) c)).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()) // Get entry with highest count
                .map(Map.Entry::getKey);
    }
    
    private List<Integer> squareNumber(int[] nums) {
        // Given a list of numbers, return a list of numbers where each number is squared and only unique results are kept.
        return Arrays.stream(nums).boxed().map(num->num*num).distinct().toList();
        
    }
    
    private double average(int[] nums) {
        //Given a list of students with their scores, find the average score of all students.
        int sum = Arrays.stream(nums).reduce(0, Integer::sum);
        return (double) sum /nums.length;
        
    }
    
    private Map<Integer,List<String>> wordLengthToWordMapper(String[] words) {
       // Given a list of words, return a mapping of word length to a list of words with that length.
        return Arrays.stream(words).collect(Collectors.groupingBy(String::length));
    }
    
    private List<Integer> thresholdExceeded(int[] nums) {
      //  Given a list of transactions with amounts, find the total sum of all transactions that exceed 5.
       return Arrays.stream(nums).boxed().filter(num->num>5).collect(Collectors.toList());
       
    }
    
    private int maxEven(int[] nums) {
        //  Given a list of numbers, find the maximum even number.
        return Arrays.stream(nums)
                .filter(num -> num % 2 == 0)
                .reduce(-1, Math::max);
        
    }
    
    
    private int getMaxEven(int[] nums) {
        return Arrays.stream(nums).filter(num->num%2==0).reduce(0, Integer::max);
    }
    
    //anyMatch,noneMatch,allMatch
    //IntStream.range
    

    
    
}