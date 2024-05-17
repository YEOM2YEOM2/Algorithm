package study.may.algo_17th_test;

import java.io.*;
import java.util.*;

public class BJ2240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] dp = new int[T + 1][W + 1]; // dp[i][j] : i번째 자두가 떨어질 때 j번 이동했을 때 먹을 수 있는 자두의 개수

        for (int i = 1; i <= T; i++) {
            int idx = Integer.parseInt(br.readLine().strip()); // 자두 나무 번호
            // 0번 이동한 경우
            if (idx % 2 == 1) dp[i][0] = dp[i - 1][0] + 1;
            else dp[i][0] = dp[i - 1][0];
            // 1번 이상 이동한 경우
            for (int j = 1; j <= W; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                if (j % 2 != idx % 2) dp[i][j]++;
            }
        }

        int ans = 0;
        for (int i = 0; i <= W; i++) ans = Math.max(dp[T][i], ans);
        System.out.println(ans);
    }
}
