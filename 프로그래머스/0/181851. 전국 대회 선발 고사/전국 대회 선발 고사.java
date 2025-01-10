import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int count = 0;
        Map<Integer, RankDTO> map = new HashMap<>();
        for (int i=0; i<rank.length; i++) {
            map.put(rank[i], new RankDTO(i, attendance[i]));
        }
        for (int i=0; i<=rank.length; i++) {
            RankDTO dto = map.get(i+1);
            if (dto.getAttendance()) {
                if (count == 0) {
                    answer += 10000 * dto.getIndex();
                    count++;
                } else if (count == 1) {
                    answer += 100 * dto.getIndex();
                    count++;
                } else {
                    answer += dto.getIndex();
                    break;
                }
            }
        }
        return answer;
    }
    
    class RankDTO {
        private int index;
        private boolean attendance;
        
        public RankDTO(int index, boolean attendance) {
            this.index = index;
            this.attendance = attendance;
        }
        
        public int getIndex() {
            return this.index;
        }
        
        public boolean getAttendance() {
            return this.attendance;
        }
    }
}