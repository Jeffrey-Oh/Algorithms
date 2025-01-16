import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;
        for (int i=size; 0<i; i--) {
            if (citations[size - i] >= i)
                return i;
        }
        return 0;
    }
}