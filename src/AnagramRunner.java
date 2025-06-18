import java.util.Map;
import java.util.TreeMap;
//Try to do this with array
public class AnagramRunner {
    TreeMap<Character,Integer> sMap = new TreeMap<>();
    TreeMap<Character,Integer> tMap = new TreeMap<>();
    public static void main(String[] args) {
        AnagramRunner runner = new AnagramRunner();
        System.out.println(runner.isAnagram("sana","anas"));
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        populateMaps(s,t);
        return validateMaps();
    }
    
    private boolean validateMaps() {
        if(sMap.entrySet().size()!= tMap.entrySet().size()) return false;
        for(Map.Entry<Character,Integer> tEntry: tMap.entrySet()){
            char key = tEntry.getKey();
            int value = tEntry.getValue();
            if(!sMap.containsKey(key) ||  (!sMap.get(key).equals(value))) {
                return false;
            }
            sMap.remove(key);
            
            
        }
        return sMap.entrySet().isEmpty();
    }
    
    private void populateMaps(String s, String t) {
        for(char c : s.toCharArray()) {
            if(!sMap.containsKey(c)){
                sMap.put(c,1);
            }else{
                sMap.put(c,sMap.get(c)+1);
            }
        }
        
        for(char c : t.toCharArray()) {
            if(!tMap.containsKey(c)){
                tMap.put(c,1);
            }else{
                tMap.put(c,tMap.get(c)+1);
            }
        }
    }
}