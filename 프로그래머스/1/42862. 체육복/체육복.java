import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 학생들의 체육복 상태를 저장할 배열
        int[] clothes = new int[n + 1];
        Arrays.fill(clothes, 1); // 기본적으로 모두 체육복 1개씩 보유

        // 잃어버린 학생 반영
        for (int lo : lost) {
            clothes[lo]--;
        }

        // 여분 체육복을 가진 학생 반영
        for (int res : reserve) {
            clothes[res]++;
        }

        // 체육복 빌려주기 처리
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) { // 체육복이 없는 학생
                if (i > 1 && clothes[i - 1] == 2) { // 왼쪽 학생에게서 빌리기
                    clothes[i]++;
                    clothes[i - 1]--;
                } else if (i < n && clothes[i + 1] == 2) { // 오른쪽 학생에게서 빌리기
                    clothes[i]++;
                    clothes[i + 1]--;
                }
            }
        }

        // 체육복을 가진 학생 수 계산
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] > 0) {
                count++;
            }
        }

        return count;
    }
}
