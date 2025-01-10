import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, Integer> alpha = new HashMap<>();
        alpha.put("zero", 0);
        alpha.put("one", 1);
        alpha.put("two", 2);
        alpha.put("three", 3);
        alpha.put("four", 4);
        alpha.put("five", 5);
        alpha.put("six", 6);
        alpha.put("seven", 7);
        alpha.put("eight", 8);
        alpha.put("nine", 9);
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c - '0' < 10) {
                if (!temp.toString().isEmpty()) {
                    sb.append(alpha.get(temp.toString()));
                    temp = new StringBuilder();
                }
                sb.append(c - '0');
            } else {
                if (!temp.toString().isEmpty() && alpha.containsKey(temp.toString())) {
                    sb.append(alpha.get(temp.toString()));
                    temp = new StringBuilder();
                    temp.append(c);
                } else temp.append(c);
            }
        }
        if (!temp.toString().isEmpty() && alpha.containsKey(temp.toString())) {
            sb.append(alpha.get(temp.toString()));
        }
        return Integer.parseInt(sb.toString());
    }
}