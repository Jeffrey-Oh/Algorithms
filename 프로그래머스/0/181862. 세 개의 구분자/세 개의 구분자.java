import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : myStr.toCharArray()) {
            if (c != 'a' && c != 'b' && c != 'c') {
                sb.append(c);
            } else {
                if (!sb.toString().isEmpty()) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
                
        }
        if (!sb.toString().isEmpty()) {
            list.add(sb.toString());
        }
        if (list.isEmpty()) list.add("EMPTY");
        return list.stream().map(String::valueOf).toArray(String[]::new);
    }
}