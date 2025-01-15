import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();
        for (String[] arr : clothes) {
            List<String> list = map.getOrDefault(arr[1], new ArrayList<>());
            list.add(arr[0]);
            map.put(arr[1], list);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            answer *= entry.getValue().size() + 1;
        }
        return answer - 1;
    }
}