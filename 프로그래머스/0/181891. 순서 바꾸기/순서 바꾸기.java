import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        result.addAll(list.subList(n, list.size()));
        result.addAll(list.subList(0, n));
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}