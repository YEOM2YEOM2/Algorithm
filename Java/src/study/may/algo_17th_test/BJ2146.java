package study.may.algo_17th_test;

import java.io.*;
import java.util.*;

public class BJ2146 {
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[][] arr;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().charAt(0) == '1') arr[i][j] = -1; // -1 : 대륙, 0 : 바다
            }
        }
        // 대륙 구분하기
        boolean[][] visited = new boolean[N][N];
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == -1) {
                    bfs(i, j, idx, visited);
                    idx++;
                }
            }
        }
        // 최단 거리 다리 찾기
        for (int i = 1; i <= idx; i++) {
            // i에 해당하는 섬에서 다른 섬까지의 최단 거리
            solution(i);
        }
        System.out.println(ans);
    }

    private static void bfs(int si, int sj, int idx, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {si, sj});
        visited[si][sj] = true;
        arr[si][sj] = idx;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];

            for (int k = 0; k < 4; k++) {
                int ni = ci + di[k];
                int nj = cj + dj[k];

                if (!isPossible(ni, nj, visited)) continue;

                q.offer(new int[]{ni, nj});
                visited[ni][nj] = true;
                arr[ni][nj] = idx;
            }
        }
    }

    private static boolean isPossible(int ni, int nj, boolean[][] visited) {
        if (ni < 0 || ni >= N || nj < 0 || nj >= N || visited[ni][nj] || arr[ni][nj] == 0) return false;
        return true;
    }

    private static void solution(int idx) {
        int[][] visited = new int[N][N]; // -1 : 방문 x, 0 : 방문 o && 대륙, 1~ : 방문 o & 다리
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == idx) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];

            for (int k = 0; k < 4; k++) {
                int ni = ci + di[k];
                int nj = cj + dj[k];
                if (ni < 0 ||  ni >= N || nj < 0 || nj >= N) continue;
                // 인접한 영역이 다른 섬일 경우
                if (arr[ni][nj] != 0 && arr[ni][nj] != idx) {
                    ans = Math.min(ans, visited[ci][cj]);
                    return;
                } else if (arr[ni][nj] == 0 && visited[ni][nj] == -1) { // 인접한 영역이 바다이고 방문하지 않은 경우
                    visited[ni][nj] = visited[ci][cj] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }
}