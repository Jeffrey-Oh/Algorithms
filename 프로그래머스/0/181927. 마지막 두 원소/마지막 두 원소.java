class Solution {
    public int[] solution(int[] num_list) {
        int last = num_list[num_list.length - 1];
        int last2 = num_list[num_list.length - 2];
        int add = 0;
        if (last > last2) {
            add = last - last2;
        } else if (last <= last2) {
            add = last * 2;
        }
        int[] answer = new int[num_list.length + 1];
        for (int i=0; i<answer.length-1; i++)
            answer[i] = num_list[i];
        answer[num_list.length] = add;
        return answer;
    }
}