import java.util.ArrayList;
import java.util.List;

public class Main {
 
    

    public boolean bruteForceValid(String s){
        int open = 0;
        for (char c: s.toCharArray()){
            open += c == '(' ? 1: -1;
            if (open < 0) return false;
        }
        return open == 0;
    }
    void bruteForceDfs(String s, List<String> res, int n) {
        if (n * 2 == s.length()){
            if (bruteForceValid(s)) res.add(s);
            return ;
        }
        bruteForceDfs(s + '(', res, n);
        bruteForceDfs(s + ')', res, n);
    }
    public List<String> bruteForce(int n){
        List<String> res = new ArrayList<>();
        bruteForceDfs("", res, n);
        return res;
    }


    //
    private void backtrack(int openN, int closedN, int n, List<String> res, StringBuilder stack){
        if (openN == closedN && openN == n){
            res.add(stack.toString());
            return;
        }
        if (openN < n){
            stack.append('(');
            backtrack(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closedN < openN){
            stack.append(')');
            backtrack(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
    public List<String> backtracking(int n){
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }

    // 
    public List<String> dynamicProgramming(int n){
        List<List<String>> res = new ArrayList<>();
        for (int i=0; i<= n; i++){
            res.add(new ArrayList<>());
        }
        res.get(0).add("");
        for (int k=0; k<=n; k++){
            for (int i=0; i<k; i++){
                for (String left: res.get(i)){
                    for (String right: res.get(k - i - 1)){
                        res.get(k).add("(" + left + ")" + right);
                    }
                }
            }
        }
        return res.get(n);
    }

}
