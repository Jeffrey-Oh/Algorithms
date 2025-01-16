import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<String> ad = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                ad.add(String.valueOf(c));
            else {
                if (!ad.isEmpty() && ad.peekLast().equals("(")) {
                    ad.pollLast();
                } else {
                    return false;
                }
            }
        }
        return ad.isEmpty();
    }
}