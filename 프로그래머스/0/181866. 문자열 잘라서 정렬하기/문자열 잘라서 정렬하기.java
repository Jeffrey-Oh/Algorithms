import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] split = myString.split("x");
        Arrays.sort(split);
        return Arrays.stream(split).filter(str -> !str.isEmpty()).toArray(String[]::new);
    }
}