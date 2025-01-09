class Solution {
    public int solution(String[] orders) {
        int answer = 0;
        for (String order : orders) {
            if (order.contains("americano") || order.equals("anything"))
                answer += 4500;
            else
                answer += 5000;
        }
        return answer;
    }
}