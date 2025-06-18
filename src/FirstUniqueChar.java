import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(new FirstUniqueChar().firstUniqChar("loveleetcode"));
    }
    LinkedHashMap<Character, CharacterDetails> map = new LinkedHashMap<>();
    
    public int firstUniqChar(String s) {
        int index =0;
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, new CharacterDetails(map.get(c).getOccurence()+1,index));
            }else{
                map.put(c, new CharacterDetails(1,index));
            }
            index++;
        }
        
        for(Map.Entry<Character, CharacterDetails> entry : map.entrySet()){
            if(entry.getValue().getOccurence() == 1){
                return entry.getValue().getIndex();
            }
           
        }
        return -1;
    }
    
    private class CharacterDetails{
        int occurence;
        int index;
        
        public CharacterDetails(int occurence, int index) {
            this.occurence = occurence;
            this.index = index;
        }
        
        public int getOccurence() {
            return occurence;
        }
        
        public int getIndex() {
            return index;
        }
    }
}