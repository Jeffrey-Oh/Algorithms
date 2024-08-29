import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int pipeCount = Integer.parseInt(stringTokenizer.nextToken());
        int tape = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> pipeList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().sorted(Integer::compareTo).collect(Collectors.toList());
        int result = 0;

        int startPipe = 0;
        int endPipe = 0;

        for (int i=0; i<pipeCount; i++) {
            int pipe = pipeList.get(i);
            if (startPipe == 0) {
                startPipe = pipe;
                endPipe = startPipe + tape - 1;
                continue;
            }

            if (pipe > endPipe) {
                result++;
                startPipe = pipe;
                endPipe = startPipe + tape - 1;
            }
        }

        if (pipeList.get(pipeCount - 1) > endPipe) result += 2;
        else result++;

        bw.write(result + "\n");
        bw.flush();
    }
}