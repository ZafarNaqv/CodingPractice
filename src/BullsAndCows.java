import java.util.*;

public class BullsAndCows {
    HashMap<Integer, Set<Integer>> digitsToIndexSecretsMap = new HashMap<>();
    HashMap<Integer, Set<Integer>> digitsToIndexGuessMap = new HashMap<>();
    public static void main(String[] args) {
        
        System.out.println(new BullsAndCows().getHint("5433519056","5330810935"));
    }
    
        /** "1807"          1123
              |              |
            "7810"          0111
         **/
    public String getHint(String secret, String guess) {
        String result = "xAyB";
        int bulls =0, cows = 0;
        populateBullsAndCowsMap(secret,guess);
        int currentBulls = 0;
        int currentCows = 0;
    
       for(Map.Entry<Integer, Set<Integer>> entry : digitsToIndexSecretsMap.entrySet()) {
           if(digitsToIndexGuessMap.containsKey(entry.getKey())){
               Set<Integer> secretSet = digitsToIndexSecretsMap.get(entry.getKey());
               Set<Integer> guessSet = digitsToIndexGuessMap.get(entry.getKey());
               currentBulls = calculateBulls(secretSet,guessSet);
               if(secretSet.size() <= guessSet.size()) {
                   currentCows = secretSet.size() - currentBulls;
               }else if(currentBulls==0){
                   currentCows = guessSet.size();
               }else{
                   currentCows = guessSet.size() - currentBulls;
               }
               bulls+=currentBulls;
               cows+=currentCows;
           }
       }
        return result.replace("x",Integer.toString(bulls)).replace("y",Integer.toString(cows));
    }
    
    private int calculateBulls(Set<Integer> secretSet, Set<Integer> guessSet) {
        int bulls=0;
        for(Integer occurrenceIndex : secretSet){
            if(guessSet.contains(occurrenceIndex)){
                bulls++;
            }
        }
        return bulls;
    }
    
    private void populateBullsAndCowsMap(String secret, String guess) {
        int index = 0;
        for(Character c:secret.toCharArray()) {
            if(!digitsToIndexSecretsMap.containsKey(c-'0')) {
                digitsToIndexSecretsMap.put(c-'0', new HashSet<>());
            }
            digitsToIndexSecretsMap.get(c-'0').add(index++);
        }
        index = 0;
        for(Character c:guess.toCharArray()) {
            if(!digitsToIndexGuessMap.containsKey(c-'0')) {
                digitsToIndexGuessMap.put(c-'0', new HashSet<>());
            }
            digitsToIndexGuessMap.get(c-'0').add(index++);
        }
    }
}