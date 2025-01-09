import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left; i<=right; i++) {
            int count = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) { 
                    count++;
                    if (j != i / j) { // 대칭되는 큰 약수 추가
                        count++;
                    }
                }
            }
            if (count % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
}