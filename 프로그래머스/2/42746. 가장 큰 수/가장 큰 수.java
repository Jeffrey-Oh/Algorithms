import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).sorted((a, b) -> (b+a).compareTo(a+b)).toArray(String[]::new);
        StringBuilder sb = new StringBuilder();
        for (String str : arr) sb.append(str);
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}