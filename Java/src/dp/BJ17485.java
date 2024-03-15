package dp;

import java.io.*;
import java.util.*;

public class BJ17485 {
    static int[][] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M][3]; // 0 : 오른쪽, 1: 직진, 2: 왼쪽

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        // dp 0번째 행 초기화
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) dp[0][i][j] = arr[0][i];
        }

        for (int i = 1; i < N; i++) {
            forward(i, 0);
            right(i, 0);

            for (int j = 1; j < M - 1; j++) {
                left(i, j);
                forward(i, j);
                right(i, j);
            }

            left(i, M - 1);
            forward(i, M -1);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) min = Math.min(min, dp[N - 1][i][j]);
        }
        System.out.println(min);
    }

    private static void left(int i, int j) {
        dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + arr[i][j];
    }

    private static void forward(int i, int j) {
        dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
    }

    private static void right(int i, int j) {
        dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + arr[i][j];
    }
}
