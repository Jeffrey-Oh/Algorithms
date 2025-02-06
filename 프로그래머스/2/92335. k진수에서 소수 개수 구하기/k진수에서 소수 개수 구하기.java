class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String radix = Integer.toString(n, k);
        StringBuilder sb = new StringBuilder();
        for (char c : radix.toCharArray()) {
            if (c != '0') {
                sb.append(c);
                continue;
            }
            
            String temp = sb.toString();
            if (!temp.isEmpty() && temp.indexOf("0") == -1 && isPrime(Long.parseLong(temp))) {
                answer++;
            }
            sb = new StringBuilder();
        }
        
        if (sb.length() > 0) {
            String temp = sb.toString();
            if (!temp.isEmpty() && temp.indexOf("0") == -1 && isPrime(Long.parseLong(temp))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num <= 1) return false;
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}