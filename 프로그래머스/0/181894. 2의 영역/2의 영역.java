class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int[] group = new int[]{-1, -1};
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 2) {
                if (group[0] == -1) group[0] = i;
                else group[1] = i;
            }
        }
        int s = group[0], e = group[1];
        if (s != -1 && e != -1) {
            answer = new int[e-s+1];
            int idx = 0;
            for (int i=s; i<=e; i++)
                answer[idx++] = arr[i];
        } else if (s == -1 && e == -1) {
            answer = new int[]{-1};
        } else {
            answer = new int[]{2};
        }
        return answer;
    }
}