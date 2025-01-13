import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : completion) {
            int count = map.get(str);
            if (count == 1) map.remove(str);
            else map.put(str, count - 1);
        }
        return map.entrySet().iterator().next().getKey();
    }
}