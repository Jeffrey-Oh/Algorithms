import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        for (int num : arr) bw.write(num + "\n");
        bw.close();
    }
}