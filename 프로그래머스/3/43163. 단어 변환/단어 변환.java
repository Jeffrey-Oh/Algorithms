import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        dfs(begin, target, words, begin.length(), 0);
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public void dfs(String begin, String target, String[] words, int n, int sum) {
        if (begin.equals(target)) {
            min = Math.min(sum, min);
            return;
        }
        
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            
            if (!word.isEmpty()) {
                int count = 0;
                for (int j=0; j<n; j++) {
                    if (begin.charAt(j) == word.charAt(j))
                        count++;
                }
                
                if (count == n - 1) {
                    String temp = words[i];
                    words[i] = "";
                    dfs(word, target, words, n, sum + 1);
                    words[i] = temp;
                }
            }
        }
    }
}