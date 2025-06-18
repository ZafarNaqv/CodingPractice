import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static void main(String[] args){
        MissingInteger mainObj = new MissingInteger();
        int [] Arr = {-1,-2,-3};
       // System.out.println(mainObj.solution( Arr));
       // System.out.println(mainObj.optimisedSolution( Arr));
        System.out.println(mainObj.correctedSolution( Arr));
    }

    public int correctedSolution(int[] A) {
        int arrayLength = A.length;
        if(arrayLength==0){
            return 1;
        }
        Set<Integer> positiveNumbers = new HashSet<>();
        for(int i:A){
            if(i>0)
                positiveNumbers.add(i);
        }
        int missingNumber=1;
        do{
            if(positiveNumbers.contains(missingNumber)){
                missingNumber++;
            }else{
                break;
            }
        }while(true);

        return missingNumber;
    }


    public int solution(int[] A) {
        if(A.length==0)
        {
            return 1;
        }
        Arrays.sort(A);
        int toSearch;
        int j =0;
        do{
            toSearch = A[j];
            j++;
        }while(j<A.length && toSearch!=A[j]);
        if(j==A.length &&A[A.length-1]>0)
        {
           return A[A.length-1]+1;
        }
        if(j==A.length)
        {
            return 1;
        }


        for(int i = j;i<A.length;i++){
            System.out.println("toSearch "+toSearch + " A[i] "+A[i]);
            if(A[i]<=toSearch){
                toSearch++;
                continue;
            }else{
                return toSearch;
            }
        }
        return 1;
    }

    public int optimisedSolution(int[] A) {
        int n = A.length;
        boolean[] present = new boolean[n + 1];
        // Mark numbers present in the array
        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] <= n) {
                present[A[i]] = true;
            }
        }

        // Find the smallest missing number
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }
}
