import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (String num : nums)
            answer.append(num);
        if (answer.charAt(0) == '0') return "0";
        return answer.toString();
    }
}