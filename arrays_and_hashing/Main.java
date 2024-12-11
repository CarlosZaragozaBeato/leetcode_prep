import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private int option;

    public boolean containsDuplicates(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (seen.contains(n)) {
                return true;
            }
            seen.add(n);
        }
        return false;
    }

    public boolean validAnagram(String s, String t) {
        int[] count = new int[26];

        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    public int[] twoSums(int[] nums, int target) {
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

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.')
                    continue;

                String squareKey = (r / 3) + "," + (c / 3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                        cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                        squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    ////////////////////////////
    public Main(int option) {
        this.option = option;
    }

    public void mainProcess() {
        switch (this.option) {
            case 1:

                break;

            case 2:

                break;
        }
    }

    // solutions
    public boolean solContainsDuplicates(int[] nums) {
        /*
         * Given an integer array nums, return true if any value appears more thatn once
         * in the array, otherwise return false /
         */
        Set<Integer> nums_seen = HashSet<>();
        for (int i =0; i < nums.length; i++){
            if (nums_seen.contains(nums[i])){
                return true;
            }
            nums_seen.add(nums[i]);
        }
        return false;
    }

    public void solValidAnagram() {
        /*
         * Given two strings s and t, return true if the two string are anagrams of
         * each other, otherwise return false.
         * 
         * An anagram is a string that contains the exact same characters as another
         * string,
         * but the order of the characters can be different
         */
    }

    public void solTwoSums() {
        /*
         * Given an array of integers nums and an integer target, return the indices
         * i and j such that nums[i] + nums[j] == target and i != j
         * 
         * You may assume that every input has exactly one pair of indices i and j that
         * satisfy the condition
         * 
         * Return the answer with the smaller index first
         */
    }

    public void solGroupAnagrams() {
        /*
         * Given an array of string strs, group all anagrams together into sublists.
         * You may return the output in any order
         * 
         * An anagram is a string that contains the exact same characters as
         * another string, but the orders of the character can be different
         */
    }

    public void solTopKFrequent(int[] nums, int k) {
        /*
         * Given an integer array nums and an integer k, return the k most frequent
         * elements within the array.
         * 
         * The test cases are generated such that the answer is always unique
         * 
         * You may return the output in any order.
         */
    }

    /*
     * Design an algorithm to encode a list of strigns to a single string.
     * The encoded string is then decoded back to the original list of string
     */
    public String solEncode(List<String> strs) {

    }

    public List<String> solDecode(String str) {
    }

    public int[] productExceptSelf(int[] nums) {
        /**
         * Given an integer array nums, return an array output where output[i]
         * is the product of all the elements of nums except nums[i].
         * Each product is guaranteed to fit in a 32-bit integer.
         * Follow-up: Could you solve it in O(n) time without using the division
         * operation?
         **/

    }

    public boolean solIsValidSudoku(char[][] board) {
        // You area given a 9x9 Sudoku board. A Sudoku board is valid if the following
        // rules are followed

        // 1. Each row must contain the digits 1 - 9 without duplicates.
        // 2. Each column must contain the digitts 1 - 9 without duplicates
        // 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits
        // 1 - 9 without duplicates.

        // Return true if the Sudoku board is valid, otherwise return false

        // Note: A board does not need to be full or be solvable to be valid.
    }

    public int solLongestConsecutive(int[] nums) {
        // Given an array of integers nums, return the length of the longest
        // consecutive sequence of elements that can be formed

        // A consecutive sequence is a sequence of elements in which each
        // element is exactly 1 greater that the previous element. The element
        // do not have to be consecutive in the original array

        // You must write an algorithm that runs on 0(n) time
    }

    //

    public static void main(String[] args) {

    }
}