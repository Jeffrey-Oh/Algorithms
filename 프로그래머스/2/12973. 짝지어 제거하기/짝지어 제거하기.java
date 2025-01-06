import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && String.valueOf(c).equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(String.valueOf(c));
            }
        }
        return stack.size() > 0 ? 0 : 1;
    }
}