import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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

        for (int i = 0; i<freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for (int n: nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i>0 && index < k; i --){
            for(int n: freq[i]){
                res[index++] = n;
                if (index == k){
                    return res;
                }
            }
        }
        return res;
    }

    public String encode(List<String> strs){
        StringBuilder res = new StringBuilder();
        for (String s: strs){
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str){
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while (str.charAt(j) != '#'){
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
    public void solContainsDuplicates() {
        /*
         * Given an integer array nums, return true if any value appears more thatn once
         * in the array, otherwise return false /
         */
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

    public int[] solTopKFrequent(int[] nums, int k) {
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
    public String encode(List<String> strs){

    }

    public List<String> decode(String str){
    //

    public static void main(String[] args) {

    }
}