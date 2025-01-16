import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int num : arr) {
            if (ad.isEmpty() || ad.peekLast() != num) {
                ad.add(num);
            }
        }
        return ad.stream().mapToInt(Integer::intValue).toArray();
    }
}