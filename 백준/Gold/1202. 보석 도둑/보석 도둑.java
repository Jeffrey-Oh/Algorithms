import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken()); // 보석 개수
        int K = Integer.parseInt(stringTokenizer.nextToken()); // 가방 개수
        List<Jewel> jewels = new ArrayList<>();
        for (int i=0; i<N; i++) { // 보석 무게와 가격
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());
            jewels.add(new Jewel(M, V));
        }
        List<Integer> bags = new ArrayList<>(); // 가방에 담을 수 있는 보석 최대 무게
        for (int i=0; i<K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        jewels.sort(Comparator.comparingInt(j -> j.M));
        Collections.sort(bags);

        // 제일 비싼 보석의 무게가 들어갈 수 있는 제일 최소값의 가방을 찾아서 담는다.
        // 가방 무게가 보석 무게보다 크거나 같아야함
        PriorityQueue<Jewel> find = new PriorityQueue<>(Comparator.comparingInt(jewel -> -jewel.V));
        long result = 0;
        int jewelIndex = 0;

        for (int bag : bags) {
            while (jewelIndex < N && jewels.get(jewelIndex).M <= bag)
                find.offer(jewels.get(jewelIndex++));
            if (!find.isEmpty())
                result += find.poll().V;
        }

        bw.write(result + "\n");
        bw.flush();
    }

    static class Jewel {
        private final int M;
        private final int V;

        public Jewel(int m, int v) {
            M = m;
            V = v;
        }
    }
}