class Solution {
    public int[] solution(String s) {
        int count = 0; // 변환수
        int zero = 0; // 제거된 0의 개수
        while (!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    sb.append(c);
                }
            }
            
            // sb 에 있는 1의 길이 값 2진법으로 표현하여 다시 시작
            s = Integer.toBinaryString(sb.length());
            
            count++;
        }
        
        return new int[]{count, zero};
    }
}