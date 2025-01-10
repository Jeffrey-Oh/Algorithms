import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        for (int i=0; i<query.length; i++) {
            int index = query[i];
            if (i % 2 == 0) {
                Arrays.fill(arr, index + 1, arr.length, -1);
                arr = Arrays.stream(arr).filter(num -> num != -1).toArray();
            } else {
                Arrays.fill(arr, 0, index, -1);
                arr = Arrays.stream(arr).filter(num -> num != -1).toArray();
            }
        }
        return Arrays.stream(arr).filter(num -> num != -1).toArray();
    }
}