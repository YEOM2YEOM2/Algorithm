package study.mar.algo_9th_test;

import java.io.*;
import java.util.*;

public class BJ1600 {
    static int K, W, H;
    static boolean[][] arr; // true : 평지, false : 장애물

    static int[] di8 = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dj8 = {1, 2, 2, 1, -1, -2, -2, -1};

    static int[] di4 = {-1, 0, 1, 0};
    static int[] dj4 = {0, 1, 0, -1};


    public static class Node {
        int i;
        int j;
        int cnt;

        public Node(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) arr[i][j] = true;
            }
        }
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int si, int sj) {
        Queue<Node> q = new LinkedList<>();
        int[][][] D = new int[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) Arrays.fill(D[i][j], Integer.MAX_VALUE);
        }

        q.offer(new Node(si, sj, 0));
        D[si][sj][0] = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.i == H - 1 && node.j == W - 1) return D[node.i][node.j][node.cnt] - 1;

            boolean flag = true;
            if (node.cnt == K) flag = false; // 말처럼 이동할 수 있는 범위를 이미 다 이동했다면 나이트로의 이동은 불가능

            if (flag) { // 말처럼 이동 가능
                for (int k = 0; k < 8; k++) {
                    int ni = node.i + di8[k];
                    int nj = node.j + dj8[k];
                    if (0 <= ni && ni < H && 0 <= nj && nj < W && arr[ni][nj] && D[ni][nj][node.cnt + 1] == Integer.MAX_VALUE) {
                        D[ni][nj][node.cnt + 1] = D[node.i][node.j][node.cnt] + 1;
                        q.offer(new Node(ni, nj, node.cnt + 1));
                    }
                }
            }

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di4[k];
                int nj = node.j + dj4[k];
                if (0 <= ni && ni < H && 0 <= nj && nj < W && arr[ni][nj] && D[ni][nj][node.cnt] == Integer.MAX_VALUE) {
                    D[ni][nj][node.cnt] = D[node.i][node.j][node.cnt] + 1;
                    q.offer(new Node(ni, nj, node.cnt));
                }
            }
        }
        return -1;
    }
}
