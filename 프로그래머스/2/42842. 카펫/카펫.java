import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow; // 전체 격자 수
        
        for (int h = 1; h <= total; h++) {
            if (total % h == 0) { // 세로 길이 h가 나눠떨어지는지 확인
                int w = total / h; // 가로 길이 계산
                
                // 조건: 테두리 격자가 brown과 일치하는지 확인
                if ((w - 2) * (h - 2) == yellow) {
                    return new int[] {w, h}; // 가로, 세로 반환
                }
            }
        }
        
        return new int[] {}; // 이론적으로 여기에 도달하지 않음
    }
}