import java.util.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
        String temp = "";
        for (char c : myString.toCharArray()) {
            if (c == 'x') {
                list.add(temp.length());
                temp = "";
                continue;
            } else {
                temp += String.valueOf(c);
            }
        }
        if (!temp.isEmpty() || myString.substring(myString.length()-1).equals("x")) list.add(temp.length());
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}