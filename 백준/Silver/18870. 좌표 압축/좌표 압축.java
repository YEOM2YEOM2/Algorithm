import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        int[] origin = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            sorted[i] = origin[i];
        }
        Arrays.sort(sorted);

        int cnt = 0;
        for (int n : sorted) {
            if (!hashMap.containsKey(n)) {
                hashMap.put(n, cnt);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : origin) sb.append(hashMap.get(n) + " ");
        System.out.println(sb);
    }
}