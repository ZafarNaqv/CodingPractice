import java.util.LinkedHashMap;

public class MaxBalloons {
    LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<>();
    public  int maxNumberOfBalloons(String text) {
        populateHashMap(text);
        return checkForBalloon();
    }
    
    public static void main(String[] args) {
        System.out.println(new MaxBalloons().maxNumberOfBalloons("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw"));
    }
    
    private int checkForBalloon() {
        
        int aCount = hashmap.getOrDefault('a',0);
   
        if(aCount == 0)
            return 0;
        int bCount = hashmap.getOrDefault('b',0);
        if(bCount ==0)
            return 0;

        int lCount = hashmap.getOrDefault('l',0);
        if(lCount <2)
            return 0;

        int nCount = hashmap.getOrDefault('n',0);
        if(nCount ==0){
            return 0;
        }

        int oCount = hashmap.getOrDefault('o',0);
        if(oCount <2){
            return 0;
        }
        int minBalloonCount = Math.min(aCount,bCount);
        minBalloonCount = Math.min(minBalloonCount,nCount);
        
        int doubleCharacterCount = Math.min(lCount,oCount);
        return Math.min(doubleCharacterCount/2,minBalloonCount);

        
        
    }
    
    private void populateHashMap(String text){
        for(char c : text.toCharArray()){
            if(hashmap.containsKey(c)){
                hashmap.put(c, hashmap.get(c)+1);
            }else{
                if(c == 'a' || c == 'b' || c == 'l' || c == 'n' || c == 'o') {
                    hashmap.put(c, 1);
                }
            }
        }
    }
}