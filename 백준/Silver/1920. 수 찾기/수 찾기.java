import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens())
            list.add(Integer.parseInt(st.nextToken()));
        list.sort(Comparator.comparingInt(o -> o));
        
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens())
            bw.write(binary_search(list, Integer.parseInt(st.nextToken())) + "\n");
        
        bw.close();
    }
    
    public static int binary_search(List<Integer> list, int search) {
        if (list.size() == 1 && list.get(0) == search)
            return 1;
        if (list.size() == 0 || list.size() == 1 && list.get(0) != search)
            return 0;
        
        int mid = list.size() / 2;
        if (list.get(mid) == search)
            return 1;
        else {
            if (search > list.get(mid))
                return binary_search(list.subList(mid + 1, list.size()), search);
            else
                return binary_search(list.subList(0, mid), search);
        }
    }
}