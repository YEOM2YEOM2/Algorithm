package study.apr.algo_12th_test;

import java.io.*;
import java.util.*;
// https://velog.io/@mong7399/java-2169%EB%B2%88-%EB%A1%9C%EB%B4%87-%EC%A1%B0%EC%A2%85%ED%95%98%EA%B8%B0
public class BJ2169 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];
        int[][] temp = new int[2][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        // i : 0번째 줄 dp 초기화 오른쪽으로만 이동 가능
        dp[0][0] = arr[0][0];
        for (int i = 1; i < M; i++) dp[0][i] = dp[0][i - 1] + arr[0][i];

        for (int i = 1; i < N; i++) {
            // 왼, 위
            temp[0][0] = dp[i - 1][0] + arr[i][0];
            for (int j = 1; j < M; j++) temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + arr[i][j];
            // 오, 위
            temp[1][M - 1] = dp[i - 1][M - 1] + arr[i][M - 1];
            for (int j = M - 2; j > -1; j--) temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + arr[i][j];
            // 세 가지 방향 중 최댓값
            for (int j = 0; j < M; j++) dp[i][j] = Math.max(temp[0][j], temp[1][j]);
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}
