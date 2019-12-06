import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 155. 最小栈
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stack2;

    public MinStack() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (x == stack2.peek()) {
            stack2.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()){
            throw  new RuntimeException("栈中元素为空");
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack2.isEmpty()){
            throw  new RuntimeException("栈中元素为空");
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        int[] a = new int[]{1,-1,2,-3,1,-4};
        for(int i : a){
            minStack.push(i);
        }
        System.out.println(minStack.getMin());
    }
}
