import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    public static TreeNode buildTree(Integer[] nodes){
        if(nodes==null){
            return null;
        }
   
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodes[0]);
        queue.offer(root);
        int i =1;
        while(!queue.isEmpty() && i<nodes.length){
            TreeNode currentNode = queue.poll();
            if (nodes[i] != null) {
                currentNode.left = new TreeNode(nodes[i]);
                queue.offer(currentNode.left);
            }
            i++;
            if(i<nodes.length && nodes[i]!=null  ){
                currentNode.right = new TreeNode(nodes[i]);
                queue.offer(currentNode.right);
            }
            i++;

        }
        return root;
    }

    public static void printTree(TreeNode root){
        if(root == null){
            System.out.println("Tree is empty");
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode!=null) {
                stringBuilder.append(currentNode.val).append(",");
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }else{
                stringBuilder.append("null,");
            }
        }
        // Trim trailing "null," values
        String result = stringBuilder.toString();
        int lastNonNullIndex = result.lastIndexOf("null,"); // Find the last non-null node
        while (lastNonNullIndex > 0 && result.substring(lastNonNullIndex).equals("null,")) {
            result = result.substring(0, lastNonNullIndex); // Remove trailing "null,"
            lastNonNullIndex = result.lastIndexOf("null,");
        }

        // Add closing bracket
        result += "\b]";
        System.out.println(result);
    }




    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.val==targetSum && root.left==null && root.right==null){
            return true;
        }

        return dfs(root,targetSum,0);
    }
    private boolean dfs(TreeNode currentNode, int targetSum, int currentSum) {
        if (currentNode == null) {
            return false;
        }
        currentSum+= currentNode.val;
        System.out.println("Current Node :" + currentNode.val +", current Sum:"+currentSum);
        if(currentSum==targetSum && currentNode.left==null && currentNode.right==null){
            return true;
        }
        return dfs(currentNode.left,targetSum,currentSum) ||  dfs(currentNode.right,targetSum,currentSum);
    }

    public static void main(String[] args) {
        Integer[] root = {0,2,8,-2};
        TreeNode rootTree = buildTree(root);
        printTree(rootTree);
        System.out.print(new TreeTraversal().hasPathSum(rootTree,0));// printTree(rootTree);
    }
}