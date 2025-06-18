public class SymmetricTree {
    
    int val;
    SymmetricTree left;
    SymmetricTree right;
    SymmetricTree() {}
    SymmetricTree(int val) { this.val = val; }
    SymmetricTree(int val, SymmetricTree left, SymmetricTree right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,6};
       // System.out.println(new SymmetricTree().isSymmetric(nums));
    }
    public boolean isSymmetric(SymmetricTree root) {
        /*for(int i :43){
        
        }*/
        return true;
    }
  
}