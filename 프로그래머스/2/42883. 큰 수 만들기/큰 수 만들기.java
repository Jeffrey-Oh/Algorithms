import java.util.*;

class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character> ad = new ArrayDeque<>();
        
        for (char c : number.toCharArray()) {
            while (!ad.isEmpty() && ad.peekLast() < c && k > 0) {
                ad.pollLast();
                k--;
            }
            ad.add(c);
        }
        
        while (k > 0) {
            ad.pollLast();
            k--;
        }
        
        StringBuilder answer = new StringBuilder();
        for (char c : ad) answer.append(c);
        
        return answer.toString();
    }
}