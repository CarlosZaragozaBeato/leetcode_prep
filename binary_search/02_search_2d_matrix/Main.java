public class Main {
    public boolean bruteForce(int[][] matrix, int target){
        for(int r =0; r<matrix.length; r++){
            for (int c = 0; c < matrix[r].length; c++){
                if (matrix[r][c] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean staircaseSearch(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;

        while(r < m && c > 0){
            if (matrix[r][c] > target){
                c--;
            }else if (matrix[r][c] < target){
                r++;
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix, int target){
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while (top <= bot){
            int row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]){
                top = row + 1;
            }else if (target < matrix[row][0]){
                bot = row - 1;
            }else{
                break;
            }
        }
        if (!(top<= bot)){
            return false;
        }
        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r){
            int m = (l +r) / 2;
            if (target > matrix[row][m]){
                l = m + 1;
            }else if (target < matrix[row][m]){
                r = m -1;
            }else{
                return true;
            }
        }
        return false;
    }
    public boolean binarySearchOnePass(int[][] matrix, int target){
        int ROWS = matrix.length, COLS = matrix[0].length;
        int l = 0, r = ROWS * COLS - 1;
        while (l <= r){
            int m = l + (r - l) / 2;
            int row = m / COLS, col = m % COLS;
            if (target > matrix[row][col]){
                l = m +1;
            }else if (target < matrix[row][col]){
                r = m - 1;
            }else{
                return true;
            }
        }
        return false;
    }



}
