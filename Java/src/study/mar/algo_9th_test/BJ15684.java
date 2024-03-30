package study.mar.algo_9th_test;

import java.io.*;
import java.util.*;

public class BJ15684 {
    static int N, M, H;
    static boolean isFinished = false;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[a][b + 1] = 2;
        }

        for (int i = 0; i <= 3; i++) { // 사다리 개수 0 ~ 3 탐색
            dfs(i, 0); // 시작 (1, 1), 가로선 개수 0개
            if (isFinished) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    // 사다리 놓기
    private static void dfs(int k, int cnt) {
        if (isFinished) return; // 0부터 탐색하므로 이미 true로 바뀌었다면 더 이상 탐색 필요 x
        if (cnt == k) {
            if (check()) isFinished = true;
            return;
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                // 가로선 2개 연속 불가능
                if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
                    arr[i][j] = 1;
                    arr[i][j + 1] = 2;
                    dfs(k, cnt + 1);
                    arr[i][j] = 0;
                    arr[i][j + 1] = 0;
                }
            }
        }
    }

    // 사다리가 모두 자신의 번호로 내려오는지 확인하는 함수
    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            int ni = 1;
            int nj = i;

            while (ni <= H) {
                // 이동시, 아래로 내려가는 건 공통 / 좌우 이동은 조건에 따라 분기
                if (arr[ni][nj] == 1) nj++;
                else if (arr[ni][nj] == 2) nj--;
                ni++;
            }

            if (nj != i) return false; // i번 사다리 출발 & i번 사다리 도착 x
        }
        return true;
    }
}