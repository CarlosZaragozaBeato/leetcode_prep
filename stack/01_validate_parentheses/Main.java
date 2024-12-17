import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Main{
    public boolean bruteForce(String s){
        while (s.contains("()") || s.contains("{}") || s.contains("[]")){
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }

    public boolean stack(String s){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();

        closeToOpen.put(')','(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');

        for (char c: s.toCharArray()){
            if (closeToOpen.containsKey(c)){
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

