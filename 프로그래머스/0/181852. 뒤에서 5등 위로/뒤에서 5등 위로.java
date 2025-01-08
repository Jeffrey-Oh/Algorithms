import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list).boxed().sorted().collect(Collectors.toList());
        int[] answer = new int[list.size() - 5];
        for (int i=0; i<answer.length; i++) answer[i] = list.get(i + 5);
        return answer;
    }
}