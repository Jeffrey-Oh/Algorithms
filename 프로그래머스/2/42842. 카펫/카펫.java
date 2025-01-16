import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        // 가로가 세로와 같거나 길어야함
        // 위의 조건을 만족하는 가로 길이를 구해야함
        // 가로 x 세로 가 정답
        int[] answer = new int[2];
        List<Integer> list = sqrts(brown + yellow);
        Collections.sort(list, Collections.reverseOrder());
        int row = 0, col = 0;
        for (int i=0; i<list.size(); i++) {
            row = list.get(i);
            col = list.get(list.size() - i - 1);
            if (brown == row * 2 + ((col - 2) * 2)) {
                if (row < col) {
                    answer[0] = list.get(i-1);
                    answer[1] = list.get(list.size() - i);
                    break;
                } else {
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        return answer;
    }
    
    public List<Integer> sqrts(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=num; i++) {
            if (num % i == 0)
                list.add(i);
        }
        return list;
    }
}