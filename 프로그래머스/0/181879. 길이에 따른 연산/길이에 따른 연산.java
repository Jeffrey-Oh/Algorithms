class Solution {
    public int solution(int[] num_list) {
        int size = num_list.length;
        int answer = size > 10 ? 0 : 1;
        for (int num : num_list) {
            if (size > 10) {
                answer += num;
            } else {
                answer *= num;
            }
        }
        return answer;
    }
}