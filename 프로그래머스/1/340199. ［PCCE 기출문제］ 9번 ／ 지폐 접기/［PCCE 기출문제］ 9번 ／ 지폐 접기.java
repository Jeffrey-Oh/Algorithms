class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            int w1 = wallet[0], w2 = wallet[1];
            int b1 = bill[0], b2 = bill[1];
            int bMin = Math.min(b1, b2);
            int wMin = Math.min(w1, w2);
            int bMax = Math.max(b1, b2);
            int wMax = Math.max(w1, w2);
            
            if (bMin > wMin || bMax > wMax) {
                if (bill[0] > bill[1])
                    bill[0] = bill[0] / 2;
                else
                    bill[1] = bill[1] / 2;
                answer++;
            } else break;
        }
        return answer;
    }
}