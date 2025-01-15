import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .forEach(str -> sb.append(str));
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}