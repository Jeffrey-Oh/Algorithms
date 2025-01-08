import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list).boxed().sorted().collect(Collectors.toList());
        int[] answer = new int[5];
        for (int i=0; i<5; i++) answer[i] = list.get(i);
        return answer;
    }
}