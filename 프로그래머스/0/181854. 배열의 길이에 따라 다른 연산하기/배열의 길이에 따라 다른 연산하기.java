class Solution {
    public int[] solution(int[] arr, int n) {
        int size = arr.length;
        int[] answer = new int[size];
        for (int i=0; i<size; i++) {
            if (size % 2 != 0 && i % 2 == 0 || size % 2 == 0 && i % 2 != 0) {
                answer[i] = arr[i] + n;
            } else {
                answer[i] = arr[i];
            }
        }
        return answer;
    }
}