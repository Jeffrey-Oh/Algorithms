import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<clothes.length; i++) {
            String type = clothes[i][1];
            if (map.containsKey(type)) {
                List<String> list = map.get(type);
                list.add(clothes[i][0]);
                map.put(type, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(clothes[i][0]);
                map.put(type, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            answer *= entry.getValue().size() + 1;
        }
        return answer - 1;
    }
}