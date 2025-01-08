class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        for (int index : index_list) {
            answer += my_string.substring(index, index+1);
        }
        return answer;
    }
}