import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0], defaultFee = fees[1];
        int perTime = fees[2], perCost = fees[3];

        // 입차 기록
        Map<Integer, Integer> inTimes = new HashMap<>();
        // 누적 주차 시간 (자동차 번호 -> 총 주차 시간)
        Map<Integer, Integer> totalTimes = new HashMap<>();

        // 기록 처리
        for (String record : records) {
            String[] parts = record.split(" ");
            int time = parseTime(parts[0]);
            int carNum = Integer.parseInt(parts[1]);
            String status = parts[2];

            if (status.equals("IN")) {
                inTimes.put(carNum, time);
            } else {
                int inTime = inTimes.remove(carNum);
                totalTimes.put(carNum, totalTimes.getOrDefault(carNum, 0) + (time - inTime));
            }
        }

        // 남아있는 차량(출차되지 않은 경우) 처리
        for (Map.Entry<Integer, Integer> entry : inTimes.entrySet()) {
            int carNum = entry.getKey();
            int inTime = entry.getValue();
            totalTimes.put(carNum, totalTimes.getOrDefault(carNum, 0) + (parseTime("23:59") - inTime));
        }

        // 자동차 번호를 정렬하여 리스트로 변환
        List<Integer> sortedCarNums = new ArrayList<>(totalTimes.keySet());
        Collections.sort(sortedCarNums);

        // 요금 계산
        int[] answer = new int[sortedCarNums.size()];
        int idx = 0;
        for (int carNum : sortedCarNums) {
            int time = totalTimes.get(carNum);
            int fee = defaultFee;
            if (time > defaultTime) {
                fee += Math.ceil((time - defaultTime) / (double) perTime) * perCost;
            }
            answer[idx++] = fee;
        }

        return answer;
    }

    // "HH:mm" → 분 단위 정수 변환
    private int parseTime(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }
}
