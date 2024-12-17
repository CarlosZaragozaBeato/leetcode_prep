import java.util.Arrays;

public class Main {
    
    public int recursive_binary_search(int l, int r, int[] nums, int target){
        if (l > r) return -1;
        int m = l + (r - l) / 2;

        if (nums[m] == target) return m;
        return (nums[m] < target) ? 
        recursive_binary_search(m +1, r, nums, target):
        recursive_binary_search(l, m-1, nums, target);
    }
    public int search(int[] nums, int target){
        return recursive_binary_search(0, nums.length -1 , nums, target);
    }


    public int iterative_binary_search(int[] nums, int target){
        int l = 0, r=nums.length -1;
        while (l <= r){
            int m = l +((r - l) / 2);
            if (nums[m] > target){
                r = m -1;
            }else if (nums[m] < target){
                l = m +1;
            }else{
                return m;
            }
        }
        return -1;
    }

    public int upper_bound(int[] nums, int target){
        int l = 0, r = nums.length;

        while (l < r){
            int m = l + ((r - l)/ 2);
            if (nums[m] > target){
                r = m;
            }else{
                l = m +1;
            }
        }
        return (l > 0 && nums[l - 1] == target) ? l - 1 : -1;
    }
    public int lower_bound(int[] nums, int target){
        int l = 0, r = nums.length;
        while (l < r){
            int m = l + (r - l) / 2;
            if (nums[m] >= target){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return (l < nums.length && nums[l] == target) ? l : -1;
    }

    public int built_in(int[] nums, int target){
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -1;
    }
}
