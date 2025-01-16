import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayDeque<Item> ad = new ArrayDeque<>();
        int max = 0;
        for (int i=0; i<priorities.length; i++) {
            int priority = priorities[i];
            max = Math.max(max, priority);
            ad.add(new Item(priority, i));
        }
        int answer = 0;
        while (!ad.isEmpty()) {
            Item item = ad.poll();
            if (max > item.getPriority()) {
                ad.addLast(item);
            } else {
                answer++;
                if (item.getLocation() == location) {
                    return answer;
                } else {
                    max = ad.stream().mapToInt(dto -> dto.getPriority()).max().getAsInt();
                }
            }
        }
        return -1;
    }
    
    public class Item {
        private int priority;
        private int location;
        
        public Item(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
        
        public int getPriority() {
            return this.priority;
        }
        
        public int getLocation() {
            return this.location;
        }
    }
}