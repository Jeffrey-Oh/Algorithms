import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Best>> map = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            List<Best> list = map.getOrDefault(genre, new ArrayList<>());
            list.add(new Best(i, genre, plays[i]));
            list.sort(Comparator.comparingInt((Best b) -> -b.getPlay()).thenComparingInt(b -> b.getIdx()));
            if (list.size() > 2) list = list.subList(0, 2);
            map.put(genre, list);
            sumMap.put(genre, sumMap.getOrDefault(genre, 0) + plays[i]);
        }
        Map<String, Integer> sortedByValue = new LinkedHashMap<>();
        sumMap.entrySet()
            .stream()
            .sorted((o1, o2) -> o2.getValue() - o1.getValue())
            .forEachOrdered(entry -> sortedByValue.put(entry.getKey(), entry.getValue()));
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedByValue.entrySet()) {
            String genre = entry.getKey();
            List<Best> list = map.get(genre);
            for (Best b : list) {
                answer.add(b.getIdx());
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public class Best {
        private int idx;
        private String genre;
        private int play;
        
        public Best(int idx, String genre, int play) {
            this.idx = idx;
            this.genre = genre;
            this.play = play;
        }
        
        public int getIdx() {
            return this.idx;
        }
        
        public String getGenre() {
            return this.genre;
        }
        
        public int getPlay() {
            return this.play;
        }
        
        public String toString() {
            return "idx = " + this.idx + ", genre = " + this.genre + ", play = " + this.play;
        }
    }
}