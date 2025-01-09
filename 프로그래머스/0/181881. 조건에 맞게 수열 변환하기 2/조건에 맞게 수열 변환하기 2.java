import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] prev = new int[arr.length];
        System.arraycopy(arr, 0, prev, 0, arr.length);
        while (true) {
            for (int i=0; i<arr.length; i++) {
                int num = arr[i];
                if (num >= 50 && num % 2 == 0) {
                    arr[i] /= 2;
                }
                else if (num < 50 && num % 2 == 1)
                    arr[i] = arr[i] * 2 + 1;
            }
            
            if (Arrays.equals(prev, arr)) break;
            System.arraycopy(arr, 0, prev, 0, arr.length);
            answer++;
        }
        return answer;
    }
}