import java.util.Arrays;

class main {
    public int bruteForce(int[] nums){
        return Arrays.stream(nums).min().getAsInt();
    }

    public int binarySearch(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while (l <= r){
            if(nums[l] < nums[r]){
                res = Math.min(res, nums[l]);
                break;
            }
            int m = 1 + (r - l) / 2;
            res = Math.min(res, nums[m]);
            if (nums[m] >= nums[l]){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return res;
    }

    public int binarySearchLowerBound(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return nums[l];
    }
}