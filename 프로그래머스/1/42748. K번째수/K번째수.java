import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] res = new int[commands.length];
        for (int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int[] temp = new int[command[1] - command[0] + 1];
            System.arraycopy(array, command[0] - 1, temp, 0, temp.length);
            sort(temp);
            res[i] = temp[command[2] - 1];
        }
        return res;
    }
    
    public void sort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            boolean swap = false;
            for (int j=0; j<arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if (!swap) break;
        }
    }
}