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
        List<Integer> oils = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        while(stringTokenizer.hasMoreTokens()) {
            bridges.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        while(stringTokenizer.hasMoreTokens()) {
            oils.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int oil = oils.get(0);
        long result = (long) oil * bridges.get(0);

        for (int i=1; i<N-1; i++) {
            if (oils.get(i) < oil)
                oil = oils.get(i);

            result += (long) oil * bridges.get(i);
        }

        bw.write(result + "\n");
        bw.flush();
    }
}