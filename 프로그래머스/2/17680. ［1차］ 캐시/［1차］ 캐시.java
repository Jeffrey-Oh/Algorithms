import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayDeque<String> ad = new ArrayDeque<>();
        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (ad.size() < cacheSize) {
                if (ad.size() != 0 && ad.contains(city)) answer++;
                else answer += 5;
                ad.addLast(city);
                continue;
            }
            
            if (ad.size() != 0 && ad.contains(city)) answer++;
            else answer += 5;
            if (ad.size() != 0) {
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