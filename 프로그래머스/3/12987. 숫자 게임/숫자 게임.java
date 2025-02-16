import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int i = 0, j = 0;
        int n = A.length;

        while (i < n && j < n) {
            if (B[j] > A[i]) {
                answer++;
                i++;
            }
            j++;
        }
        
        return answer;
    }
}