import java.util.concurrent.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int answer = 0;
        ConcurrentHashMap<String, Integer> map1 = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
        
        for (int i=0; i<str1.length()-1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
                String str = String.valueOf(c1) + String.valueOf(c2);
                map1.put(str, map1.getOrDefault(str, 0) + 1);
            }
        }
        
        for (int i=0; i<str2.length()-1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
                String str = String.valueOf(c1) + String.valueOf(c2);
                map2.put(str, map2.getOrDefault(str, 0) + 1);
            }
        }
        
        int g = 0, t = 0;
        
        for (ConcurrentHashMap.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (map2.containsKey(key)) {
                int map2Value = map2.get(key);
                int min = Math.min(value, map2Value);
                int max = Math.max(value, map2Value);
                g += min;
                t += max;
                map2.remove(key);
            } else {
                t += value;
            }
            map1.remove(key);
        }
        
        for (String key : map2.keySet()) {
            t += map2.get(key);
            map2.remove(key);
        }
        
        if (g == 0 && t == 0)
            return 65536;
        
        return (int) Math.floor(((double) g / t) * 65536);
    }
}