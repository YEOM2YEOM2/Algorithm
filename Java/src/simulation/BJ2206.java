package simulation;

import java.io.*;
import java.util.*;

// 시간 초과
public class BJ2206 {
    static int N, M;
    static int[][] arr;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(temp[j]);
        }

        int ans = 1000001;
        for (int i = 0; i < N; i++) { // 1000 * 1000 체크하는 부분 → 시간 초과
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    ans = Math.min(ans, bfs(0, 0));
                    arr[i][j] = 1;
                }
            }
        }
        System.out.println(ans == 1000001 ? -1 : ans);
    }

    private static int bfs(int si, int sj) {
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[N][M];

        q.add(new Node(si, sj));
        visited[si][sj] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];

                if (0 <= ni && ni < N && 0 <= nj && nj < M && arr[ni][nj] == 0 && visited[ni][nj] == 0) {
                    q.add(new Node(ni, nj));
                    visited[ni][nj] = visited[node.i][node.j] + 1;
                }
            }
        }

        return visited[N - 1][M - 1] == 0 ? 1000001 : visited[N - 1][M - 1];
    }
}
