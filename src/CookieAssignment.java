import java.util.Arrays;

public class CookieAssignment {

    public static void main(String[] args) {
      int[] greedFactor = new int[]{1,2,3};
      int[] cookieSize = new int[]{1,1};
        System.out.println(new CookieAssignment().findContentChildren(greedFactor,cookieSize));
    }
    
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        int childContent = 0;
        while(child < g.length && cookie < s.length ){
           if(s[cookie] >= g[child]){
               childContent++;
               child++;
           }
           cookie++;
        }
        return childContent;
    }
    
   
}