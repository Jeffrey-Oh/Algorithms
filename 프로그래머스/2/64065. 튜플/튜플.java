import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        int size = s.split("},").length;
        String[] temp = new String[Math.max(1, size)];
        int idx = 0;
        boolean openClose = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '{' && !openClose)
                openClose = true;
            else if (c == '}' && openClose) {
                openClose = false;
                
                if (tempSb.length() != 0) {
                    idx++;
                    sb.append(tempSb).append(",");
                    tempSb = new StringBuilder();
                }
                
                temp[idx - 1] = sb.toString();
                sb = new StringBuilder();
                idx = 0;
            }
            else if (c == ',') {
                if (tempSb.length() != 0) {
                    idx++;
                    sb.append(tempSb).append(",");
                    tempSb = new StringBuilder();
                }
            }
            else {
                tempSb.append(c);
            }
        }
        
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        
        for (String str : temp) {
            str = str.substring(0, str.length() - 1);
            String[] split = str.split(",");
            for (String sp : split) {
                int num = Integer.parseInt(sp);
                if (!lhs.contains(num))
                    lhs.add(num);
            }
        }
        
        return lhs.stream().mapToInt(Integer::intValue).toArray();
    }
}