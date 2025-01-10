import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<numbers.length; i++) {
            int a = numbers[i];
            for (int j=i+1; j<numbers.length; j++) {
                int b = numbers[j];
                if (!set.contains(a + b))
                    set.add(a + b);
            }
        }
        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}