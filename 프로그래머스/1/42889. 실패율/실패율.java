import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N + 2];  // 각 스테이지에 도달한 사람 수 (1 ~ N+1)
        
        // 각 스테이지에 도달한 플레이어 수 카운트
        for (int stage : stages) {
            stageCount[stage]++;
        }
        
        int totalPlayers = stages.length;  // 전체 플레이어 수
        Map<Integer, Double> failureRates = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            int failed = stageCount[i];
            
            // 실패율 계산 (도달한 플레이어가 없으면 실패율 0)
            double failureRate = (totalPlayers == 0) ? 0.0 : (double) failed / totalPlayers;
            failureRates.put(i, failureRate);
            
            totalPlayers -= failed;  // 다음 스테이지로 넘어간 플레이어 수 업데이트
        }
        
        // 실패율 기준 내림차순, 실패율 같으면 스테이지 번호 오름차순
        return failureRates.entrySet().stream()
            .sorted(Map.Entry.<Integer, Double>comparingByValue(Comparator.reverseOrder())
            .thenComparing(Map.Entry.comparingByKey()))
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}