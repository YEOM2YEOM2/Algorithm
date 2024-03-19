package study.mar.algo_9th_test;

import java.io.*;
import java.util.*;

public class BJ1743 {
    static int N, M, K;
    static boolean[][] arr;
    static boolean[][] visited;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r][c] = true;
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] && !visited[i][j]) ans = Math.max(ans, bfs(i, j));
            }
        }
        System.out.println(ans);
    }

    private static int bfs(int si, int sj) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(si, sj));
        visited[si][sj] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];
                if (1 <= ni && ni <= N && 1 <= nj && nj <= M && arr[ni][nj] && !visited[ni][nj]) {
                    cnt++;
                    visited[ni][nj] = true;
                    q.offer(new Node(ni, nj));
                }
            }
        }
        return cnt;
    }
}