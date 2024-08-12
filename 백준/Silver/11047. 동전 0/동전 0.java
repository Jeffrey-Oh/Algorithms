import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");
        int coins = Integer.parseInt(nk[0]);
        int searchCoins = Integer.parseInt(nk[1]);
        Integer[] arr = new Integer[coins];
        for (int i=0; i<coins; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;
        for (Integer coin : arr) {
            if (searchCoins < coin) continue;
            if (searchCoins % coin == 0) {
                sum += searchCoins / coin;
                break;
            }

            int usedCoin = searchCoins / coin;
            searchCoins = searchCoins % coin;
            sum += usedCoin;
        }

        bw.write(sum + "\n");
        bw.flush();
    }
}