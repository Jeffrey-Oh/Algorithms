import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        StringBuilder result = new StringBuilder();

        // Convert the input number into a list of digits
        List<Integer> list = Arrays.stream(N.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        // Check if the sum of the digits is divisible by 3
        int sum = list.stream().mapToInt(Integer::intValue).sum();

        // Check if the number contains at least one '0'
        if (sum % 3 != 0 || !list.contains(0)) {
            bw.write("-1\n");
        } else {
            // Sort the digits in descending order
            list.sort(Collections.reverseOrder());
            for (Integer integer : list) {
                result.append(integer);
            }
            bw.write(result.toString() + "\n");
        }

        bw.flush();
    }
}