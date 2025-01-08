import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (Arrays.stream(delete_list).noneMatch(find -> find == num))
                list.add(num);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}