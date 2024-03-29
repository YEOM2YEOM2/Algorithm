import java.io.*;
import java.util.*;

public class Main {
    public static class Coin{
        int p;
        int c;

        public Coin(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 3; t++) {
            int N = Integer.parseInt(br.readLine().strip());
            Coin[] coins = new Coin[N];
            boolean[] dp = new boolean[100_001];

            int sum = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().strip());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(p, c);
                sum += p * c;

                for (int j = 1; j <= c; j++) dp[p * j] = true;
            }

            if (sum % 2 == 1) {
                System.out.println(0);
                continue;
            }

            for (int i = 0; i < N; i++) {
                int p = coins[i].p;
                int c = coins[i].c;

                for (int j = sum / 2; j >= p; j--) {
                    if (dp[j - p]) {
                        for (int k = 1; k <= c; k++) {
                            if (j - p + p * k > sum / 2) break;
                            dp[j - p + p * k] = true;
                        }
                    }
                }
            }

            System.out.println(dp[sum / 2] ? 1 : 0);
        }
    }
}