public class FlowerPlantation {
    public static void main(String[] args) {
        System.out.println(new FlowerPlantation().canPlaceFlowers(new int []{1,0,1,0,0,0,0},3));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int planted =0;
        if(n==0)
            return true;
        if(flowerbed.length == 1 && n==1 && flowerbed[0]==1){
            return false;
        }
        if(flowerbed.length == 1 && n==1 && flowerbed[0]==0){
            return true;
        }
     
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==0 && canPlant(flowerbed, i )){
                planted++;
                flowerbed[i] = 1;
                if(planted==n){
                    return true;
                }
            }
            
        }
        return false;
    }
    
    boolean canPlant(int[] flowerbed, int index) {
        if(index==0 && flowerbed[1]==1){
            return false;
        }
        if(index==0 && flowerbed[1]==0){
            return true;
        }
        if(index== flowerbed.length-1 && flowerbed[index-1]==0){
            return true;
        }
        if(index== flowerbed.length-1 && flowerbed[index-1]==1){
            return false;
        }
        if(index>0 && flowerbed[index-1]==0 && flowerbed[index+1]==0 && index+1<flowerbed.length){
            return true;
        }
       
        return false;
    }
}