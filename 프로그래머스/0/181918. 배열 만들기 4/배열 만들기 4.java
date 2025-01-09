import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack();
        for (int i=0; i<arr.length; i++) {
            int num = arr[i];
            if (stack.isEmpty() || stack.peek() < num) stack.push(num);
            else {
                stack.pop();
                i--;
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}