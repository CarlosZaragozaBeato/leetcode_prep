import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /*
     * Given an array of string strs, group all anagrams together into sublists. You
     * may
     * return the output in any order.
     * 
     * An anagram is a string that contains the exact same characters as another
     * string,
     * but the order of the characters can be different
     */

    public Solution() {

    }

    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> res = new HashMap<>();
        
        for (String s: strs){
            int [] count = new int[26];
            for (char c: s.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }

    // Sorting
    public List<List<String>> sorting(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }

    // HashTables
    public List<List<String>> hashTables(String[] strs){
        Map<String, List<String>> res = new HashMap<>();

        for (String s:strs){
            int[] count = new int[26];
            for (char c: s.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
 


    public static void main(String[] args) {
        String[] strs = { "act", "pots", "tops", "cat", "stop", "hat" };

        Solution slt = new Solution();


        // SOLUTIONS 
        List<List<String>> res = slt.sorting(strs);
        res = slt.hashTables(strs);
        
        // MY SOLUTION
        res = slt.groupAnagrams(strs)

        System.out.println(res);

    }

}
