import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] dp1 = {1, 2, 3, 4, 5};
        int[] dp2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] dp3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == dp1[i % dp1.length])
                map.put(1, map.getOrDefault(1, 0) + 1);
            if (answers[i] == dp2[i % dp2.length])
                map.put(2, map.getOrDefault(2, 0) + 1);
            if (answers[i] == dp3[i % dp3.length])
                map.put(3, map.getOrDefault(3, 0) + 1);
        }
        int max = map.get(1);
        if (max < map.get(2)) max = map.get(2);
        if (max < map.get(3)) max = map.get(3);
        List<Integer> list = new ArrayList<>();
        if (map.get(1) == max) list.add(1);
        if (map.get(2) == max) list.add(2);
        if (map.get(3) == max) list.add(3);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}