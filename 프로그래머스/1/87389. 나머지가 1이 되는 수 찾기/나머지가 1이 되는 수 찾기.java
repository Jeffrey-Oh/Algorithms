import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 1000000;
        for (int i=2; i<n; i++) {
            if (n % i == 1) {
                answer = Math.min(answer, i);
            }
        }
        return answer;
    }
}