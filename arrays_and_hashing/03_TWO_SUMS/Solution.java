import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * Given an array of integers nums and an integers target, return the indices
     * i and j such that nums[i] + nums [j] == target and i != j
     * 
     * 
     * You may assume that every input has exactly one pair of indices
     * i and j that sastify the condition
     */

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (seen.containsKey(diff)) {
                return new int[] {
                        seen.get(nums[i]), i
                };
            }

            seen.put(nums[i], i);
        }
        return new int[] {};
    }



    // BRUTE FORCE 
    public int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j<nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    // Sorting 
    public int[] sorting(int[] nums, int target){
        int[][] A = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            A[i][0] = nums[i];
            A[i][1] = i;
        }
        Arrays.sort(A, Comparator.comparingInt(a -> a[0]));
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int cur = A[i][0] + A[j][0];
            if (cur == target) {
                return new int[]{Math.min(A[i][1], A[j][1]), 
                                 Math.max(A[i][1], A[j][1])};

            }else if (cur < target){
                i++;
            }else{
                j--;
            }
        }
        return new int[0];
    }

    // HashMap Two pass
    public int[] hashMapTwoPass(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            indices.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (indices.containsKey(diff) && indices.get(diff) != i){
                return new int[]{
                    i, indices.get(diff)
                };
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {

    }
}
