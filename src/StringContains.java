public class StringContains {
    public static void main(String[] args) {
        StringContains sc = new StringContains();
        //System.out.println(sc.strStr("mississippi","issipi"));
        System.out.println(sc.strStr("saaadbut","aadb"));
    }
    
    
    
    public int strStr(String haystack, String needle) {
        int needleIndex = 0;
        int hayStackIndex = 0;
        int firstOccurence = -1;
        while(needleIndex < needle.length() && hayStackIndex <haystack.length()){
            if(haystack.charAt(hayStackIndex) == needle.charAt(needleIndex) ){
                hayStackIndex++;
                needleIndex++;
                if(needleIndex == needle.length()){
                    return hayStackIndex-needle.length();
                }
            }else{
                hayStackIndex = hayStackIndex - needleIndex +1;
                needleIndex = 0;
                
            }
            
        }
            return firstOccurence;
    }
}