import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            bw.write(0 + "\n");
            bw.flush();
            return;
        }
        List<Integer> cards = new ArrayList<>();
        for (int i=0; i<N; i++) cards.add(Integer.parseInt(br.readLine()));

        int result = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(cards);

        while(!queue.isEmpty()) {
            int firstMin = queue.poll();
            if (!queue.isEmpty()) {
                int secondMin = queue.poll();
                int sum = firstMin + secondMin;
                result += sum;
                queue.offer(sum);
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}