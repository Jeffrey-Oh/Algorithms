import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int[] size = new int[31];
        int max = 0;
        for (int i=0; i<strArr.length; i++) {
            size[strArr[i].length()]++;
        }
        for (int i=0; i<size.length; i++) {
            max = Math.max(max, size[i]);
        }
        return max;
    }
}