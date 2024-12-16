
public class Main {
    public int bruteForce(int[] heights){
        int res = 0;
        for(int i = 0; i<heights.length; i++){
            for (int j = i+1; j<heights.length; j++){
                res = Math.max(res, Math.min(heights[i], heights[j]) * (j - 1));
            }
        }
        return res;
    }


    public int twoPointers(int[] heights){
        int l = 0;
        int r = heights.length -1;
        int res = 0;

        while (l < r){
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, area);
            if (heights[l] <= heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
