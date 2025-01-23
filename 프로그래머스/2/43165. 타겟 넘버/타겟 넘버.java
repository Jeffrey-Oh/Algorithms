class Solution {
    int max;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return max;
    }
    
    public void dfs(int[] numbers, int target, int index, int sum) {
        if (numbers.length == index) {
            if (sum == target) max++;
            return;
        }
        
        dfs(numbers, target, index + 1, sum + numbers[index]);
        
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}