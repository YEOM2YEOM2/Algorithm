package study.jan.algo_1st_dfs_bfs;

import java.io.*;
import java.util.*;

public class BJ2583 {
    static int N, M, K;
    static int[][] arr;
    static boolean[][] visited;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Node {
        int ci;
        int cj;

        public Node(int ci, int cj) {
            this.ci = ci;
            this.cj = cj;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int sj = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            int ej = Integer.parseInt(st.nextToken());
            int ei = Integer.parseInt(st.nextToken());

            for (int i = si; i < ei; i++) {
                for (int j = sj; j < ej; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        ArrayList<Integer> cntArea = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                    cntArea.add(bfs(i, j));
                }
            }
        }

        Collections.sort(cntArea);
        System.out.println(cnt);
        for (Integer area : cntArea) {
            System.out.print(area + " ");
        }
    }

    static int bfs(int ci, int cj) {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(ci, cj));
        visited[ci][cj] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int k = 0; k < 4; k++) {
                int ni = node.ci + di[k];
                int nj = node.cj + dj[k];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && arr[ni][nj] == 0) {
                    cnt++;
                    visited[ni][nj] = true;
                    q.offer(new Node(ni, nj));
                }
            }
        }
        return cnt;
    }
}
