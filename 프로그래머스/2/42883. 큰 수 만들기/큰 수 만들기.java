import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>(); // 스택 역할

        for (char digit : number.toCharArray()) {
            // 스택의 최상단 숫자가 현재 숫자보다 작고, 제거할 기회(k)가 남아 있다면 제거
            while (!stack.isEmpty() && stack.peekLast() < digit && k > 0) {
                stack.pollLast(); // 스택에서 제거
                k--; // 제거 기회 소진
            }

            stack.addLast(digit); // 현재 숫자를 스택에 추가
        }

        // 스택에서 상위 k개의 숫자를 제거 (필요 없는 경우)
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        // 스택의 내용을 문자열로 변환
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
