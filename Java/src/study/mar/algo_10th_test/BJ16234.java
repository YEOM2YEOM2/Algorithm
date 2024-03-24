package study.mar.algo_10th_test;

import java.io.*;
import java.util.*;

public class BJ16234 {
    static int N, L, R;
    static int[][] arr;
    static int[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Node{
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        while (true) {
            int idx = 1;
            boolean flag = false; // true : 이동 가능, false : 이동 불가능

            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        if (bfs(i, j, idx)) flag = true;
                        idx++;
                    }
                }
            }

            if (flag) ans++;
            else break;
        }

        System.out.println(ans);
    }

    private static boolean bfs(int si, int sj, int idx) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(si, sj));
        visited[si][sj] = idx;

        int cnt = 1;
        int sum = arr[si][sj];
        boolean flag = false;
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && visited[ni][nj] == 0) {
                    int diff = Math.abs(arr[node.i][node.j] - arr[ni][nj]);
                    if (L <= diff && diff <= R) {// 두 나라의 인구 수 차이가 범위 안에 들어온다면
                        cnt++;
                        sum += arr[ni][nj];
                        flag = true;
                        visited[ni][nj] = idx;
                        q.offer(new Node(ni, nj));
                    }
                }
            }
        }

        if (flag) {
            int population = sum / cnt;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == idx) arr[i][j] = population;
                }
            }
        }

        return flag;
    }
}
