package study.mar.algo_10th_test;

import java.io.*;
import java.util.*;

public class BJ1943 {
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
            boolean[] dp = new boolean[100_001]; // true : 해당 값을 만들 수 있음. / false : 해당 값을 만들 수 없음.

            int sum = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().strip());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(p, c);
                sum += p * c;

                for (int j = 1; j <= c; j++) dp[p * j] = true;
            }

            if (sum % 2 == 1) { // sum의 합이 짝수가 아니면 정확히 나눌 수 없음.
                System.out.println(0);
                continue;
            }

            for (int i = 0; i < N; i++) {
                int p = coins[i].p;
                int c = coins[i].c;

                for (int j = sum / 2; j >= p; j--) {
                    if (dp[j - p]) { // dp[j - p]가 false, (dp[j], dp[j + p], dp[j + 2p, ...) 도달 불가능
                        for (int k = 1; k <= c; k++) {
                            if (j - p + p * k > sum / 2) break; // sum / 2 보다 큰 값을 만들 수 있는지 알 필요 없음.
                            dp[j - p + p * k] = true;
                        }
                    }
                }
            }

            System.out.println(dp[sum / 2] ? 1 : 0);
        }
    }
}
