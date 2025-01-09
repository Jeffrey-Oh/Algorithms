import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (!stack.isEmpty() && stack.peek() == num) stack.pop();
            else stack.push(num);
        }
        return stack.isEmpty() ? new int[]{-1} : stack.stream().mapToInt(Integer::intValue).toArray();
    }
}