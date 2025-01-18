import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Truck> trucks = new ArrayDeque<>();
        ArrayDeque<Truck> onBridge = new ArrayDeque<>();
        int answer = 0;
        
        for (int truckWeight : truck_weights) {
            trucks.add(new Truck(truckWeight));
        }
        
        while (!trucks.isEmpty() || !onBridge.isEmpty()) {
            answer++;
            
            Truck doneTruck = null;
            int sum = 0;
            
            for (Truck truck : onBridge) {
                sum += truck.weight;
                truck.move();
                
                if (truck.getPosition() > bridge_length) {
                    doneTruck = truck;
                }
            }
            
            if (doneTruck != null) {
                onBridge.remove(doneTruck);
                sum -= doneTruck.getWeight();
            }
            
            if (!trucks.isEmpty() && onBridge.size() < bridge_length) {
                Truck truck = trucks.peek();
                
                if (truck.getWeight() + sum <= weight) {
                    trucks.remove(truck);
                    onBridge.add(truck);
                    truck.move();
                }
            }
        }
        
        return answer;
    }
    
    class Truck {
        private int weight;
        private int position;
        
        Truck(int weight) {
            this.weight = weight;
            this.position = 0;
        }
        
        public int getWeight() {
            return this.weight;
        }
        
        public int getPosition() {
            return this.position;
        }
        
        public void move() {
            this.position++;
        }
        
        public String toString() {
            return "weight = " + this.weight + ", position = " + this.position;
        }
    }
}