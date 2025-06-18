import java.util.*;
import java.util.stream.Collectors;

public class AscendingSum {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String sum = "3+2+1";
        List<Integer> numbers = Arrays.stream(sum.split("\\+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //System.out.println(numbers);
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        //System.out.println(sortedList);
        String result = sortedList.stream().map(String::valueOf).collect(Collectors.joining("+"));

        System.out.println(result.substring(0,result.length()));
    }

}
