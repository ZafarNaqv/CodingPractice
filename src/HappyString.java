import java.util.PriorityQueue;


public class HappyString {
    public static void main(String[] args) {
        System.out.println(new HappyString().longestDiverseString(7,1,0));
    }
    
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharacterPair> maxHeap = new PriorityQueue<>((pair1, pair2) -> pair2.count - pair1.count);
        StringBuffer result = new StringBuffer();
        if(a>0) {
            maxHeap.offer(new CharacterPair(a, 'a'));
        }
        if(b>0) {
            maxHeap.offer(new CharacterPair(b, 'b'));
        }
        if(c>0) {
            maxHeap.offer(new CharacterPair(c, 'c'));
        }
        while(!maxHeap.isEmpty()) {
            CharacterPair top = maxHeap.poll();
            boolean validSequence = isSequenceValid(result,top.character);
            if(!validSequence){
               CharacterPair secondMax = maxHeap.poll();
               maxHeap.offer(top);
                if(secondMax != null) {
                    result.append(secondMax.character);
                    secondMax.count--;
                    if (secondMax.count > 0) {
                        maxHeap.offer(secondMax);
                    }
                }else{
                    break;
                }
            }else{
                result.append(top.character);
                top.count--;
                if(top.count>0){
                    maxHeap.offer(top);
                }
            }
        }

        
        
        return result.toString();
    }
    
    private boolean isSequenceValid(StringBuffer result, char character) {
        result.append(character);
        if (result.toString().contains(Character.toString(character).repeat(3))) {
            result.deleteCharAt(result.length()-1);
            return false;
        }
        result.deleteCharAt(result.length()-1);
        return true;
    }
    
    static class CharacterPair{
        int count;
        char character;
        
        public CharacterPair(int count, char character) {
            this.count = count;
            this.character = character;
        }
        
        @Override
        public String toString() {
            return "CharacterPair{" +
                    "count=" + count +
                    ", character=" + character +
                    '}';
        }
    }
    
}