import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayDeque<String> ad = new ArrayDeque<>();
        int idx = 0;
        for (String word : words) {
            if (ad.size() == 0) {
                ad.addLast(word);
                idx++;
                continue;
            }
            
            if (!word.startsWith(ad.peekLast().substring(ad.peekLast().length()-1)) || ad.contains(word)) {
                // 탈락
                break;
            } else {
                // 패스
                ad.addLast(word);
                idx++;
                if (idx + 1 > n) idx = 0;
            }
        }
        
        if (ad.size() != words.length) {
            answer[0] = idx + 1;
            answer[1] = (ad.size() + 1) % n == 0 ? (ad.size() + 1) / n : (ad.size() + 1) / n + 1;
        }
        
        return answer;
    }
}