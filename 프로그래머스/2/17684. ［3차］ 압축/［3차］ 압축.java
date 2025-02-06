import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        int index = 1;
        while (index <= 26) {
            map.put(String.valueOf((char) (65 + index - 1)), index++);
        }
        
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<msg.length(); i++) {
            String w = String.valueOf(msg.charAt(i));
            sb.append(w);
            
            int add = 0;
            for (int j=i+1; j<msg.length(); j++) {
                w = String.valueOf(msg.charAt(j));
                sb.append(w);
                String s = sb.toString();
                
                if (!map.containsKey(s)) {
                    map.put(s, index++);
                    break;
                }
                add++;
            }
            
            if (i + add + 1 < msg.length()) {
                String find = sb.substring(0, sb.length() - 1);
                if (!find.isEmpty()) {
                    list.add(map.get(find));
                    sb = new StringBuilder();
                }
            } else {
                list.add(map.get(sb.toString()));
            }
            i += add;
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}