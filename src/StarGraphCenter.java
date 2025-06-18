import java.util.HashMap;

public class StarGraphCenter {
    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {2,3},
                {4,2},
        };
        System.out.println(new StarGraphCenter().findCenter(edges));
    }
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int[] edge : edges) {
           if(hashmap.containsKey(edge[0])) {
               hashmap.put(edge[0],hashmap.get(edge[0])+1);
           }else{
               hashmap.put(edge[0],1);
           }
            if(hashmap.containsKey(edge[1])) {
                hashmap.put(edge[1],hashmap.get(edge[1])+1);
            }else{
                hashmap.put(edge[1],1);
            }
        }
        int maxNodes = hashmap.keySet().size()-1;
        for(Integer key : hashmap.keySet()) {
            if(hashmap.get(key) == maxNodes) {
                return key;
            }
        }
        return 0;
        
    }
    
}