import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dp; // [i][j] 현재 위치 i, j에서 도착점 N-1, M-1까지의 경로의 개수

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M]; // 방문 처리, 경로 중복 탐색 방지용
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int ci, int cj) {
        if (ci == N - 1 && cj == M - 1) return 1; // 도착점까지 올 수 있는 새로운 경로
        if (dp[ci][cj] != -1) return dp[ci][cj]; // 이미 도착점까지의 경로가 정리된 dp[ci][cj] 반환

        dp[ci][cj] = 0; // ci, cj 방문 처리
        for (int i = 0; i < 4; i++) {
            int ni = ci + di[i];
            int nj = cj + dj[i];
            if (0 <= ni && ni < N && 0 <= nj && nj < M && arr[ni][nj] < arr[ci][cj]) {
                dp[ci][cj] += dfs(ni, nj);
            }
        }

        return dp[ci][cj];
    }
}