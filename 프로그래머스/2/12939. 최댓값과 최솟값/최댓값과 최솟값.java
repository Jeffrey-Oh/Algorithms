import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        List<Integer> list = Arrays.stream(arr).mapToInt(Integer::parseInt).boxed().sorted().collect(Collectors.toList());

        int min = list.get(0);
        int max = list.get(list.size()-1);
        return min + " " + max;
    }
}