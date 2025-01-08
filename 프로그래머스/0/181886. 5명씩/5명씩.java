import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> list = new ArrayList<>();
        String[] answer = new String[names.length / 5];
        for (int i=0; i<names.length; i++) {
            if (i % 5 == 0)
                list.add(names[i]);
        }
        return list.stream().toArray(String[]::new);
    }
}