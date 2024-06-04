package dp;

import java.io.*;
import java.util.*;

public class BJ11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];
        // arr 입력 및 dp 행합 구하기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum += arr[i][j];
                dp[i][j] = sum;
            }
        }
        // dp 채우기, dp[i][j] : (1, 1) ~ (i, j) 까지의 합
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= N; j++) dp[i][j] = dp[i - 1][j] + dp[i][j];
        }

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine().strip());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
            System.out.println(sum);
        }
    }
}