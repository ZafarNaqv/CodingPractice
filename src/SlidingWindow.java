public class SlidingWindow {
    int fruitBasketType = -1;
    int fruitBasketTwoType = -1;
    
    int startIndex = 0;
    int endIndex = 0;
    int maxBasketSize = 2;
    public static void main(String[] args) {
        
        System.out.println(new SlidingWindow().totalFruit(new int[]{0,1,2,2}));
    }
    
    public int totalFruit(int[] fruits) {
        
        if(fruits.length<=1)
            return fruits.length;
        fruitBasketType = fruits[0];
        for (int i = 1; i < fruits.length ; i++) {
            if(fruitBasketTwoType==-1 && fruits[i]!=fruitBasketType){
                fruitBasketTwoType = fruits[i];
            }
            if(canAddtoBasket(fruits,i)){
                endIndex = i;
                maxBasketSize = Math.max(maxBasketSize,endIndex-startIndex+1);
            }else{
                int newFruit = fruits[i];
                int oldRemainingFruit = updateBaskets(fruits,i)==1 ? fruitBasketTwoType : fruitBasketType;
                for (int j = startIndex; j <i ; j++) {
                    if((fruits[j]!=oldRemainingFruit && fruits[j]!=newFruit)){
                        startIndex = j+1;
                       
                    }
                
                }
                updateBaskets(fruits,i);
                endIndex = i;
              
            }
            
        }
        return maxBasketSize;
    }
    
    private int updateBaskets(int[] fruits, int index){
        if(fruits[index-1]==fruitBasketType){
            fruitBasketTwoType=fruits[index];
            return 2;
        }else{
            fruitBasketType=fruits[index];
            return 1;
        }
    }
    
    private boolean canAddtoBasket(int[] fruits, int index) {
        return fruits[index] == fruitBasketType || fruits[index] == fruitBasketTwoType;
    }
    
}