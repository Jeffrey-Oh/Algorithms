import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i=0; i<progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int sum = 0;
            while (progress < 100) {
                progress += speed;
                sum++;
            }
            progresses[i] = sum;
        }
        int max = progresses[0], job = 1;
        for (int i=1; i<progresses.length; i++) {
            if (progresses[i] > max) {
                max = progresses[i];
                ad.add(job);
                job = 1;
            } else {
                job++;
            }
        }
        ad.add(job);
        return ad.stream().mapToInt(Integer::intValue).toArray();
    }
}