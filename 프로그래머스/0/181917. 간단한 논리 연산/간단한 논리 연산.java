class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        // V true 가 하나라도 있으면 true 반대는 false 가 있으면 false
        return (x1 || x2) && (x3 || x4);
    }
}