import java.util.Arrays;

public class SonarCodilityChallenge {
    public static void main(String[] args) {
        int[] arr = new int[]{6,-2,3,0,-4};
        System.out.println(new SonarCodilityChallenge().solution(arr));
        System.out.println(new SonarCodilityChallenge().solutionUnoptimised(arr));
    }

    public int solution(int[] A) {
       int arrayLength = A.length;

       int maxLeftSide[] = new int[arrayLength];
        int maxRightSide[] = new int[arrayLength];

       maxLeftSide[0] = A[0];
       for(int i =1;i<arrayLength;i++){
           maxLeftSide[i] = Math.max(maxLeftSide[i-1],A[i]);
       }

       maxRightSide[arrayLength-1] = A[arrayLength-1];
       for(int j=arrayLength-2;j>=0;j--){
           maxRightSide[j] = Math.max(maxRightSide[j+1],A[j]);
       }
        int maxDifference = Integer.MIN_VALUE;
       for(int splitIndex=0;splitIndex<A.length-1;splitIndex++){
           maxDifference = Math.max(maxDifference,Math.abs(maxLeftSide[splitIndex]-maxRightSide[splitIndex+1]));
       }
       return maxDifference;


    }

    public int solutionUnoptimised(int[] A) {
        int arrayLength = A.length;
        int maxDifference = Integer.MIN_VALUE;
        for(int split=1;split<arrayLength;split++){
            int[] leftArr =  Arrays.copyOfRange(A,0,split);
            int[] rightArr =  Arrays.copyOfRange(A,split,arrayLength);
            int leftMax = computeMax(leftArr);
            int rightMax = computeMax(rightArr);
            maxDifference = Math.max(maxDifference,Math.abs(rightMax-leftMax));
        }
        return maxDifference;
    }

    private int computeMax(int[] arr) {
        int max = arr[0];
        for(int i:arr){
            max= Math.max(max,i);
        }
        return max;
    }


}
