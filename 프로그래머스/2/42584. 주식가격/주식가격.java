import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i=0; i<prices.length; i++) {
            int price = prices[i];
            for (int j=i+1; j<prices.length; j++) {
                answer[i]++;
                if (price > prices[j]) break;
            }
        }
        return answer;
    }
}