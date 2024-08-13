import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] buttons = {300, 60, 10};
        int T = Integer.parseInt(br.readLine());
        if (T % 10 != 0) {
            bw.write(-1 + "\n");
            bw.flush();
            return;
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(true) {
            if (i == 3) {
                if (T > 0) {
                    result = new ArrayList<>();
                    result.add(-1);
                }
                break;
            }
            
            int button = buttons[i];
            int touch = T / button;
            if (T < button) {
                i++;
                result.add(touch);
                continue;
            }

            T %= button;
            i++;
            result.add(touch);
        }

        bw.write(result.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
        bw.flush();
    }
}