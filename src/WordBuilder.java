import java.util.HashMap;
import java.util.Map;

public class WordBuilder {
    HashMap<Character, Integer> characterOccurenceMap = new HashMap<>();
    
    public static void main(String[] args) {
        String[] wordArr = {"lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo"};
        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        System.out.println(new WordBuilder().countCharacters(wordArr, chars));
    }
    
    public int countCharacters(String[] words, String chars) {
        characterOccurenceMap = populateCharacterOccurenceMap(characterOccurenceMap, chars);
        int sum = 0;
        for (String word : words) {
            HashMap<Character, Integer> wordMap = new HashMap<>();
            wordMap = populateCharacterOccurenceMap(wordMap, word);
            sum += buildWords(wordMap);
        }
        return sum;
    }
    
    private int buildWords(HashMap<Character, Integer> wordMap) {
        int charLength = 0;
        for (Map.Entry<Character, Integer> entrySet : wordMap.entrySet()) {
            if (characterOccurenceMap.containsKey(entrySet.getKey()) && characterOccurenceMap.get(entrySet.getKey()) >= entrySet.getValue()) {
                charLength += entrySet.getValue();
            } else {
                return 0;
            }
        }
        return charLength;
    }
    
    private HashMap<Character, Integer> populateCharacterOccurenceMap(HashMap<Character, Integer> map, String word) {
        for (Character c : word.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}