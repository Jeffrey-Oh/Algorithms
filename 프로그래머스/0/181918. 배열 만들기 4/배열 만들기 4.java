import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayDeque <Integer> ad = new ArrayDeque();
        for (int i=0; i<arr.length; i++) {
            int num = arr[i];
            if (ad.isEmpty() || ad.peekLast() < num)
                ad.addLast(num);
            else {
                ad.removeLast();
                i--;
            }
        }
        return ad.stream().mapToInt(Integer::intValue).toArray();
    }
}