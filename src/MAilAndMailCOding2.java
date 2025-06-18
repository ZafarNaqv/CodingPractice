import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MAilAndMailCOding2 {
    // When you have a List of null values and Lists of Integers and null
// values, how would you calculate the sum of all integers using java >= 8 ?

    
    
    public static void main(String[] args) {
        
        List<Integer> l1 = Arrays.asList(1,5,2,null,3);
        List<Integer> l2 = Arrays.asList(3,null,4,null,5);
        
        List<List<Integer>> list = Arrays.asList(l1, null, l2);
        
        System.out.println("sum = " + sumListsJava8(list));
        
    }
    
    private static int sumLists(List<List<Integer>> list) {
        int sum =0;
        for(List<Integer> l : list){
            if(l != null) {
                for (Integer i : l) {
                    if (i != null) {
                        sum += i;
                    }
                }
            }
        }
        return sum;
        
        
    }
    
    
    private static int sumListsJava8(List<List<Integer>> list) {

        return list.stream().filter(Objects::nonNull).flatMap(List::stream).filter(Objects::nonNull).reduce(0, Integer::sum);
    }
}