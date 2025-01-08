import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        for (int i=0; i<my_string.length(); i++) {
            answer[i] = my_string.substring(i, my_string.length());
        }
        return Arrays.stream(answer).map(String::toString).sorted().toArray(String[]::new);
    }
}