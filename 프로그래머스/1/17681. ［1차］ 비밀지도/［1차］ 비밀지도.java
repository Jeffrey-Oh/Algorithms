class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<arr1.length; i++) {
            String map = Integer.toBinaryString(arr1[i] | arr2[i]);
            if (map.length() < n) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<n-map.length(); j++) {
                    sb.append(0);
                }
                map = sb.toString() + map;
            }
            
            answer[i] = map.replace("1", "#").replace("0", " ");
        }
        return answer;
    }
}