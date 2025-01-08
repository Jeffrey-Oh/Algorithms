import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        return Arrays.stream(my_string.trim().split(" ")).filter(find -> !find.isEmpty()).toArray(String[]::new);
    }
}