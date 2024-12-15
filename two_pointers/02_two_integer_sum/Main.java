import java.util.HashMap;
import java.util.Map;

class Main{

    public int[] custom(int[]numbers, int target){
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < numbers.length; i++){
            int diff = target - numbers[i];
            if (seen.containsKey(diff)){
                return new int []{
                    seen.get(diff) + 1, i + 1
                };
            }
            seen.put(numbers[i], i);
        }
        return new int[]{};
    }


    public int[] bruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target){
                    return new int[] {i + 1, j +1};
                }
            }
        }
        return new int[0];
    }

    
    public int[] binarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int l = i +1, r= numbers.length - 1;
            int tmp = target - numbers[i];

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == tmp){
                    return new int[]{i + 1, mid + 1};
                }else if (numbers[mid] < tmp){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return new int[0];
    }


    public int[] hashMap(int[] numbers, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            int tmp = target - numbers[i];
            if (mp.containsKey(tmp)){
                return new int []{mp.get(tmp), i + 1};
            }
            mp.put(numbers[i], i + 1);
        }
        return new int[0];
    }


    public int[] twoPointers(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r){
            int curSum = numbers[l] + numbers[r];

            if (curSum > target){
                r --;
            }else if (curSum < target){
                l++;
            }else{
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[0];
    }

}