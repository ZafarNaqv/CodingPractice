package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class BackTrackingPractice {
    public static void main(String[] args) {
        BackTrackingPractice runner = new BackTrackingPractice();
       /* List<List<Integer>> permutations = runner.permute(new int[]{1,2,3,4});
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }*/
        
        /*List<List<Integer>> powerSet = runner.subsets(new int[]{1,2,3,4,5,6,7,8,10,0});
        for (List<Integer> subSets : powerSet) {
            System.out.println(subSets);
        }*/
        
      /*  HashSet<List<Integer>> hashSet = new HashSet<>();
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(2, 1, 3);
        List<Integer> list3 = List.of(3, 2, 1);
        hashSet.add(list1);
        hashSet.add(list2);
        hashSet.add(list3);
        
        List<HashSet<Integer>> listOfHashSet = new ArrayList<>();
        listOfHashSet.add(new HashSet<>(list1));
        listOfHashSet.add(new HashSet<>(list2));
        listOfHashSet.add(new HashSet<>(list3));
        
        
        HashSet<HashSet<Integer>> hashSetofHashSet = new HashSet<>();
        hashSetofHashSet.add(new HashSet<>(list1));
        hashSetofHashSet.add(new HashSet<>(list2));
        hashSetofHashSet.add(new HashSet<>(list3));
        
        
        System.out.println(hashSet);
        System.out.println("Now List of HashSet");
        System.out.println(listOfHashSet);
        System.out.println("Now HashSet of HashSet");
        System.out.println(hashSetofHashSet);*/
        
        String[] nums = {"000","101","001","010"};
        System.out.println(runner.findDifferentBinaryString(nums));
        
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        recursiveBacktrack(nums,currentPermutation,used,result);
        return result.stream().toList();
    }
    
    private void recursiveBacktrack(int[] nums, List<Integer> currentPermutation, boolean[] used, HashSet<List<Integer>> result) {
        if (nums.length == currentPermutation.size()) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            
            used[i] = true;
            currentPermutation.add(nums[i]);
            recursiveBacktrack(nums,currentPermutation,used,result);
            used[i] = false;
            currentPermutation.remove(currentPermutation.size()-1);
            
        }
    }
    
    
    //https://leetcode.com/problems/subsets/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backtrackPowerSet(nums,0,currentList,result);
        return result.stream().map(ArrayList::new).collect(Collectors.toList());
    }
    private void backtrackPowerSet(int[] nums, int startIndex, List<Integer> currentList,  List<List<Integer>> result ) {
      result.add(new ArrayList<>(currentList));
      for(int i=startIndex;i<nums.length;i++){
        currentList.add(nums[i]);
        backtrackPowerSet(nums,i+1,currentList,result);
        currentList.remove(currentList.size()-1);
      }
    }
    
    //https://leetcode.com/problems/find-unique-binary-string/description/?envType=problem-list-v2&envId=backtracking
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> numsSet = new HashSet<>(List.of(nums));
        StringBuilder currentString = new StringBuilder();
        int maxSize = nums[0].length();
        return generateBinaryStrings(maxSize, currentString,numsSet);
    }
    
    
    private String generateBinaryStrings(int maxSize, StringBuilder currentString,HashSet<String> numsSet) {
        if(currentString.length() == maxSize){
            if(!numsSet.contains(currentString.toString())){
                return currentString.toString();
            }else{
                return null;
            }
        }
        currentString.append('0');
        String result = generateBinaryStrings(maxSize, currentString, numsSet);
        if (result != null) return result;
        currentString.deleteCharAt(currentString.length()-1);
        currentString.append('1');
        result = generateBinaryStrings(maxSize, currentString, numsSet);
        if (result != null) return result;
        currentString.deleteCharAt(currentString.length()-1);
        
        return null;
    }
}