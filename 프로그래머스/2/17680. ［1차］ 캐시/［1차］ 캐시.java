import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        LinkedHashSet<String> cache = new LinkedHashSet<>();
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (cache.contains(city)) {
                answer++;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                
                if (cache.size() > 0 && cacheSize == cache.size()) {
                    cache.remove(cache.iterator().next());
                }
                
                cache.add(city);
            }
        }
        return answer;
    }
}