import java.io.*;
import java.util.*;

public class Main {
    static class Path implements Comparable<Path> {
        int s;
        int e;
        int d;

        public Path(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Path o) {
            if (this.s == o.s) return this.e - o.e;
            return this.s - o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        // dp 초기화
        int[] dp = new int[10001];
        for (int i = 0; i < 10001; i++) dp[i] = i;

        Path[] path = new Path[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            path[i] = new Path(s, e, d);
        }
        Arrays.sort(path);

        for (int i = 0; i < N; i++) {
            int s = path[i].s;
            int e = path[i].e;
            int d = path[i].d;

            if (D < e) continue;

            if (dp[s] + d < dp[e]) {
                dp[e] = dp[s] + d;
                for (int j = e + 1; j < 10001; j++) {
                    if (dp[e] + j - e < dp[j]) dp[j] = dp[e] + j - e;
                    else break;
                }
            }
        }
        System.out.println(dp[D]);
    }
}