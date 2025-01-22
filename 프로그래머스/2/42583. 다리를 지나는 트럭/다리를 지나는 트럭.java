import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Truck> waits = new ArrayDeque<>();
        ArrayDeque<Truck> onBridge = new ArrayDeque<>();
        
        for (int truck_weight : truck_weights)
            waits.add(new Truck(truck_weight));
        
        int sec = 0;
        
        while (!waits.isEmpty() || !onBridge.isEmpty()) {
            sec++;
            
            Truck done = null;
            int sum = 0;
            
            for (Truck onTruck : onBridge) {
                sum += onTruck.getWeight();
                onTruck.move();
                
                if (onTruck.getPosition() > bridge_length) {
                    done = onTruck;
                }
            }
            
            if (done != null) {
                onBridge.remove(done);
                sum -= done.getWeight();
            }
            
            if (!waits.isEmpty() && onBridge.size() < bridge_length) {
                Truck truck = waits.peek();
                if (truck.getWeight() + sum <= weight) {
                    onBridge.add(truck);
                    waits.remove(truck);
                    truck.move();
                }
            }
        }
        
        return sec;
    }
    
    class Truck {
        private int weight;
        private int position;
        
        Truck (int weight) {
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
    }
}