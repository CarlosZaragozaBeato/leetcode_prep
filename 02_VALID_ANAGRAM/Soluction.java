import java.util.Arrays;
import java.util.HashMap;

public class Soluction{



    public boolean soluction01(String s, String t){
        if (s.length() != t.length()){
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();

        Arrays.sort(sSort);
        Arrays.sort(tSort);

        return Arrays.equals(sSort, tSort);

     }

     public boolean solution02 (String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for (int i = 0; i<s.length(); i++){
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return countS.equals(countT);

     }


     public boolean solution03(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

        int[] count = new int[26];

        for (int i =0; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }  

        for  (int val: count){
            if (val != 0){
                return false;
            }
        }
        return true;
     }


    
    public static void main(String args []){
        
    }
}
