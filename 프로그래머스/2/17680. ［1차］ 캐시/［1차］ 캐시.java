import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayDeque<String> ad = new ArrayDeque<>();
        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (!ad.isEmpty() && ad.contains(city)) answer++;
            else answer += 5;
            
            if (ad.size() < cacheSize) {
                ad.addLast(city);
                continue;
            }
            
            if (!ad.isEmpty()) {
                if (ad.contains(city)) {
                    ad.remove(city);
                } else {
                    ad.pop();
                }
                ad.addLast(city);
            }
        }
        return answer;
    }
}