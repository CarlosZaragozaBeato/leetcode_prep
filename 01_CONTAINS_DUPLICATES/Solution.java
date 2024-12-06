import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Solution {

    

    // public boolean soluction01(int[] nums) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[i] == nums[j]) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // public boolean soluction02(int[] nums){
    //     Arrays.sort(nums);
    //     for (int i = 0;i<nums.length; i++) {
    //         if (nums[i] == nums[i-1]){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public boolean soluction03(int[] nums) {
    //     Set<Integer> seen = new HashSet<>();

    //     for (int num: nums){
    //         if (seen.contains(nums)){
    //             return true;
    //         }
    //         seen.add(num);
    //     }
    //     return false;

    // }

    // public boolean soluction04(int[] nums) {
    //     return Arrays.stream(nums).distinct().count() < nums.length;
    // }


    public static void main(String args[]) {}
}
