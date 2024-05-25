package study.may.algo_18th_test;

import java.io.*;
import java.util.*;

public class BJ17406 {
    static int N, M, K;
    static int ans = Integer.MAX_VALUE;
    static int[][] arr;
    static int[][] calc;
    static int[] order;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        order = new int[K];
        visited = new boolean[K];
        calc = new int[K][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().strip());
            for (int j = 1; j <= M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < 3; j++) calc[i][j] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        System.out.println(ans);
    }

    private static void perm(int k) {
        if (k == K) {
            ans = Math.min(ans, solution());
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                order[k] = i;
                visited[i] = true;
                perm(k + 1);
                visited[i] = false;
            }
        }
    }

    private static int solution() {
        // 배열 복사
        int[][] copyArr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) copyArr[i][j] = arr[i][j];
        }
        // 회전 연산
        for (int i = 0; i < K; i++) rotate(i, copyArr);
        // 회전 연산 후 각 행의 합 中 최솟값 찾기
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= M; j++) temp += copyArr[i][j];
            min = Math.min(min, temp);
        }
        return min;
    }

    private static void rotate(int idx, int[][] copyArr) {
        // 시계방향으로 옮기기 위한 배열
        int[][] temp = new int[N + 1][M + 1];

        int r = calc[order[idx]][0];
        int c = calc[order[idx]][1];
        int s = calc[order[idx]][2];
        temp[r][c] = copyArr[r][c];
        for (int k = s; k > 0; k--) {
            for (int j = c - k + 1; j <= c + k; j++) temp[r - k][j] = copyArr[r - k][j - 1]; // 윗변
            for (int i = r - k + 1; i <= r + k; i++) temp[i][c + k] = copyArr[i - 1][c + k]; // 우변
            for (int j = c + k - 1; j >= c - k; j--) temp[r + k][j] = copyArr[r + k][j + 1]; // 아랫변
            for (int i = r + k - 1; i >= r - k; i--) temp[i][c - k] = copyArr[i + 1][c -k]; // 좌변
        }
        //  temp -> copyArr 복사
        for (int i = r - s; i <= r + s; i++) {
            for (int j = c - s; j <= c + s; j++) copyArr[i][j] = temp[i][j];
        }
    }
}