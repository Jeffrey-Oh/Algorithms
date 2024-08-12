import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigDecimal[] coins = new BigDecimal[]{BigDecimal.valueOf(0.25), BigDecimal.valueOf(0.10), BigDecimal.valueOf(0.05), BigDecimal.valueOf(0.01)};
        int N = Integer.parseInt(br.readLine());
        List<String[]> results = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            double C = Double.parseDouble(br.readLine());
            BigDecimal changes = new BigDecimal(String.valueOf(C / 100));
            String[] result = new String[4];

            int k = 0;
            do {
                if (coins[k].doubleValue() <= changes.doubleValue()) {
                    BigDecimal convertChanges = new BigDecimal(String.valueOf(changes));
                    BigDecimal convertCoins = new BigDecimal(String.valueOf(coins[k]));
                    BigDecimal mod = convertChanges.divideToIntegralValue(convertCoins);
                    result[k] = String.valueOf(mod.intValue());
                    changes = convertChanges.subtract(convertCoins.multiply(mod));
                    k++;
                } else {
                    result[k] = String.valueOf(0);
                    k++;
                }
            } while (k != 4);
            results.add(result);
        }

        for (String[] result : results) {
            for (int j = 0; j < result.length; j++) {
                if (j + 1 < result.length) {
                    bw.write(result[j] + " ");
                } else {
                    bw.write(result[j] + "\n");
                }
            }
        }
        bw.flush();
    }
}