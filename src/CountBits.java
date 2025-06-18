import java.util.HashMap;

public class CountBits {
    HashMap<Integer,Integer> hashmap = new HashMap();
    int[] arr;
    CountBits(int n){
        arr = new int[n+1];
    }

    public static void main(String[] args) {
        CountBits obj = new CountBits(20);
        printArr(obj.countBits(20));
    }

    public int[] countBits(int n) {
        for(int i=n;i>=0;i--){
            if(hashmap.containsKey(i)){
                arr[i] = hashmap.get(i);
            }else{
                arr[i] = Integer.bitCount(i);
                hashmap.put(i, arr[i]);
            }
        }
        return arr;
    }
    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(i+" ---> " +arr[i]);
        }
    }
}
