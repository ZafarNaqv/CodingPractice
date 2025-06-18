public class NumDecodings {

    public NumDecodings(String s) {

    }
    
    
    public static void main(String[] args) {
        String s = "111";
        System.out.println(new NumDecodings(s).numDecodings(s));
    }
    
    public int numDecodings(String s)
    {
        int n = s.length();
        int[] res = new int[n+1];
        
        res[0] = 1;
        res[1] = s.charAt(0) == '0' ? 0 :1;
        for(int i=2;i<=n;i++)
        {
            String lastNumber = s.substring(i-1,i);
            String lastTwoNumber = s.substring(i-2,i);
            if(!lastNumber.equals("0")){
                res[i] += res[i-1];
            }
            if(Integer.parseInt(lastTwoNumber)>=10 && Integer.parseInt(lastTwoNumber)<27){
                res[i] += res[i-2];
            }
        }
        
     return res[n];
    }
}