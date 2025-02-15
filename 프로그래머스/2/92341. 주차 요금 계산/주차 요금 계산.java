import java.util.*;
import java.time.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        final String STATUS_IN = "IN";
        int defaultTime = fees[0], defaultFee = fees[1];
        int perTime = fees[2], perCost = fees[3];
        
        Map<String, String> parks = new HashMap<>();
        Map<String, Integer> cars = new HashMap<>();
        
        for (String record : records) {
            String[] infos = record.split(" ");
            String time = infos[0];
            String carNum = infos[1];
            String status = infos[2];
            
            if (status.equals(STATUS_IN)) {
                parks.put(carNum, time);
            } else {
                String inTime = parks.get(carNum);
                parks.remove(carNum);
                
                int diff = calcTime(inTime, time);
                
                int totalTime = cars.getOrDefault(carNum, 0);
                cars.put(carNum, totalTime + diff);
            }
        }
        
        // 남은 차량 처리
        for (Map.Entry<String, String> car : parks.entrySet()) {
            int diff = calcTime(car.getValue(), null);
            
            String carNum = car.getKey();
            int totalTime = cars.getOrDefault(carNum, 0);
            cars.put(carNum, totalTime + diff);
        }
        
        // 비용 처리
        List<Car> list = new ArrayList<>();
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            String carNum = car.getKey();
            int totalTime = car.getValue();
            int totalFee = defaultFee;
            
            if (totalTime > defaultTime) {
                int over = totalTime - defaultTime;
                int mod = over / perTime;
                int remain = over % perTime;
                
                if (remain > 0) {
                    mod++;
                }
                
                totalFee += mod * perCost;
            }
            
            list.add(new Car(carNum, totalFee));
        }
        
        list.sort((c1, c2) -> Integer.parseInt(c1.getCarNum()) - Integer.parseInt(c2.getCarNum()));
        
        return list.stream().mapToInt(car -> car.getFee()).toArray();
    }
    
    public int calcTime(String inTime, String time) {
        LocalTime t1 = LocalTime.parse(inTime);
        if (time == null) time = "23:59";
        LocalTime t2 = LocalTime.parse(time);

        return (int) Duration.between(t1, t2).toMinutes();
    }
    
    class Car {
        private String carNum;
        private int fee;
        
        Car(String carNum, int fee) {
            this.carNum = carNum;
            this.fee = fee;
        }
        
        public String getCarNum() {
            return this.carNum;
        }
        
        public int getFee() {
            return this.fee;
        }
    }
}