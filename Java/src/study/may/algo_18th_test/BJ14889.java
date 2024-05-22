package study.may.algo_18th_test;

import java.io.*;
import java.util.*;

public class BJ14889 {
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        arr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);
        System.out.println(ans);
    }

    public static void comb(int s, int k) {
        if (k == N / 2) {
            ans = Math.min(ans, solution());
            return;
        }

        for (int i = s; i < N; i++) {
            visited[i] = true;
            comb(i + 1, k + 1);
            visited[i] = false;
        }
    }

    public static int solution() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) { // 스타트 팀
                for (int j = 0; j < N; j++) if (visited[j]) start += arr[i][j];
            } else {
                for (int j = 0; j < N; j++) if (!visited[j]) link += arr[i][j];
            }
        }

        return Math.abs(start - link);
    }
}