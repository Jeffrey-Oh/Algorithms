import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int size = arr.length;
        int i = 0;
        while (size > Math.pow(2, i)) {
            i++;
        }
        int maxSize = (int) Math.pow(2, i);
        int[] answer = new int[maxSize];
        for (int j=0; j<size; j++) {
            answer[j] = arr[j];
        }
        return answer;
    }
}