import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int stage : stages) {
            q.add(stage);
        }
        
        int size = stages.length;
        
        for (int i=1; i<=N; i++) {
            int failed = 0;
            int check = 0;
            while (check < size) {
                check++;
                int current = q.poll();
                if (current == i) {
                    failed++;
                } else q.add(current);
            }
            Double ratio = (double) failed / size;
            if (ratio.isNaN()) ratio = 0.0;
            map.put(i, ratio);
            size = q.size();
        }
        
        return map.entrySet().stream()
            .sorted(Map.Entry.<Integer, Double>comparingByValue(Comparator.reverseOrder())
            .thenComparing(Map.Entry.comparingByKey()))
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}