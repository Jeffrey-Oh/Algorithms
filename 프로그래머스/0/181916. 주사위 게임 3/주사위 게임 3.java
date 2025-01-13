import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] dices = {a, b, c, d};
        
        Map<Integer, Integer> fq = new HashMap<>();
        for (int dice : dices) {
            fq.put(dice, fq.getOrDefault(dice, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(fq.entrySet());
        list.sort((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue()))
                return o2.getValue() - o1.getValue();
            return o1.getKey() - o2.getKey();
        });
        
        if (list.size() == 1) {
            return 1111 * list.get(0).getKey();
        } else if (list.size() == 2) {
            int num1 = list.get(0).getKey();
            int num2 = list.get(1).getKey();
            if (list.get(0).getValue() == 3) {
                return (int) Math.pow(10 * num1 + num2, 2);
            } else {
                return (num1 + num2) * Math.abs(num1 - num2);
            }
        } else if (list.size() == 3) {
            int num1 = list.get(1).getKey();
            int num2 = list.get(2).getKey();
            return num1 * num2;
        } else {
            return Arrays.stream(dices).min().getAsInt();
        }
    }
}