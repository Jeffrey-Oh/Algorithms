import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        arr = Arrays.stream(arr).distinct().toArray();
        System.arraycopy(arr, 0, answer, 0, arr.length < k ? arr.length : k);
        if (arr.length < k) {
            Arrays.fill(answer, arr.length, k, -1);
        }
        return answer;
    }
}