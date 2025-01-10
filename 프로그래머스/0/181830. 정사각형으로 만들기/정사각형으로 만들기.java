import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int rows = arr.length;
        int cells = arr[0].length;
        int max = Math.max(rows, cells);
        int[][] answer = new int[max][max];
        if (rows != cells) {
            for (int i=0; i<arr.length; i++) {
                System.arraycopy(arr[i], 0, answer[i], 0, arr[i].length);
            }
        } else {
            answer = arr;
        }
        return answer;
    }
}