import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> bridges = new ArrayList<>();
        List<Integer> stations = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        while(stringTokenizer.hasMoreTokens()) {
            bridges.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        while(stringTokenizer.hasMoreTokens()) {
            stations.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int result = 0;

        for (int i=0; i<N; i++) {
            Integer station = stations.get(i);
            if (i + 1 < N && station > stations.get(i + 1)) {
                result += station * bridges.get(i);
            } else {
                while(true) {
                    if (i + 1 < N && station <= stations.get(i)) {
                        result += station * bridges.get(i++);
                    } else break;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}