import java.util.Stack;

public class Main {

    // Brute Force
    class BruteForce{
        private Stack<Integer> stack;
    
    
        public BruteForce(){
            stack = new Stack<>();
        }

        public void push(int val){
            stack.push(val);
        }
        public void pop(){
            stack.pop();
        }
        public int top(){
            return stack.peek();
        }
        public int getMin(){
            Stack<Integer> tmp = new Stack<>();
            int mini = stack.peek();

            while (!stack.isEmpty()){
                mini = Math.min(mini, stack.peek());
                tmp.push(stack.pop());
            }
            while(!tmp.isEmpty()){
                stack.push(tmp.pop());
            }
            return mini;
        }
    }


    class TwoStack{
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public TwoStack(){
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        public void push (int val){
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()){
                minStack.push(val);
            }
        }
        public void pop(){
            if (stack.isEmpty()) return;
            int top = stack.pop();
            if (top == minStack.peek()){
                minStack.pop();
            }
        }
        public int top(){
            return stack.peek();
        }
        public int getMin(){
            return minStack.peek();
        }
    }
    class OneStack{
        long min;
        Stack<Long> stack;
        public OneStack(){
            stack = new Stack<>();
        }
        public void push(int x){
            if (stack.isEmpty()){
                stack.push(0L);
                min = x;
            }else{
                stack.push(x - min);
                if (x < 0)min = min - x;
            }
        }
        public void pop(){
            if (stack.isEmpty()) return;
            long pop = stack.pop();
            if (pop < 0) min = min - pop;
        }
        public int top(){
            long top = stack.peek();
            if (top > 0){
                return (int) (top + min);
            }else{
                return (int) min;
            }
        }
        public int getMin(){
            return (int) min;
        }    
    }

    

}
