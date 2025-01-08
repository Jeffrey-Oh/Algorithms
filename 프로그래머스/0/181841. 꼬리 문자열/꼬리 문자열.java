import java.util.*;

class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        str_list = Arrays.stream(str_list).filter(find -> !find.contains(ex)).toArray(String[]::new);
        for (String str : str_list)
            answer += str;
        return answer;
    }
}