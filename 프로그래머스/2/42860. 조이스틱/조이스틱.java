import java.util.*;

class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;

        // 알파벳 변경 비용 계산
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 커서 이동 최소 비용 계산
        int minMove = n - 1; // 초기값: 끝까지 직진하는 경우
        for (int i = 0; i < n; i++) {
            // 연속된 A 구간 찾기
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            // (왼쪽으로 이동 후 돌아가기)와 (끝까지 직진)의 최소값 비교
            int move = i + n - next + Math.min(i, n - next);
            minMove = Math.min(minMove, move);
        }

        answer += minMove;
        return answer;
    }
}