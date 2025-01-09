import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            for (int j=s; j<=e; j++) {
                if (arr[j] > k) {
                    list.add(arr[j]);
                }
            }
            if (!list.isEmpty()) {
                Collections.sort(list);
                answer.add(list.get(0));
                list = new ArrayList<>();
            } else {
                answer.add(-1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}