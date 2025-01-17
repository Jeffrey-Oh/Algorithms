import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프 생성
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // 다익스트라 알고리즘으로 최단 거리 계산
        int[] distances = bfs(graph, n, 1);

        // 최대 거리 찾기 및 해당 거리 노드 개수 세기
        int maxDistance = Arrays.stream(distances).max().orElse(0);
        int count = (int) Arrays.stream(distances).filter(d -> d == maxDistance).count();

        return count;
    }

    private int[] bfs(Map<Integer, List<Integer>> graph, int n, int start) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1); // 방문하지 않은 노드는 -1로 초기화
        distances[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int neighbor : graph.get(currentNode)) {
                if (distances[neighbor] == -1) { // 방문하지 않은 노드만 처리
                    distances[neighbor] = distances[currentNode] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return distances;
    }
}
