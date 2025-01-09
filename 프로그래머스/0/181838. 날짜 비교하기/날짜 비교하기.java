import java.time.*;

class Solution {
    public int solution(int[] date1, int[] date2) {
        LocalDate date11 = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate date22 = LocalDate.of(date2[0], date2[1], date2[2]);
        return date11.isEqual(date22) ? 0 : date11.isBefore(date22) ? 1 : 0;
        
    }
}