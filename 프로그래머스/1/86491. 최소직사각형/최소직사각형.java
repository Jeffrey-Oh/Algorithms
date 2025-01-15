import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int[][] rows = Arrays.stream(sizes).sorted(Comparator.comparingInt((int[] num) -> -num[0])).toArray(int[][]::new);
        for (int i=0; i<rows.length; i++) {
            int row = rows[i][0];
            int col = rows[i][1];
            if (row < col) {
                rows[i][0] = col;
                rows[i][1] = row;
            }
        }
        rows = Arrays.stream(sizes).sorted(Comparator.comparingInt((int[] num) -> -num[0])).toArray(int[][]::new);
        int[][] cols = Arrays.stream(sizes).sorted(Comparator.comparingInt((int[] num) -> -num[1])).toArray(int[][]::new);
        return rows[0][0] * cols[0][1];
    }
}