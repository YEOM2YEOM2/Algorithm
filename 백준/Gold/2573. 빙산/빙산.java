import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution() + "\n");
        bw.flush();
        bw.close();
    }

    private static int solution() {
        int time = 1;
        while (true) {
            int[][] copy = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int ni = i + di[k];
                            int nj = j + dj[k];
                            if (0 <= ni && ni < N && 0 <= nj && nj < M && arr[ni][nj] <= 0) cnt++;
                        }

                        copy[i][j] = arr[i][j] - cnt;
                    }
                }
            }
            // 배열 복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = copy[i][j];
            }
            // 빙하가 2개 이상으로 분리되었는지 확인
            visited = new boolean[N][M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && arr[i][j] > 0) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            if (cnt >= 2) return time;
            if (cnt == 0) break;

            time++;
        }
        return 0;
    }

    private static void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && arr[ni][nj] > 0) {
                    visited[ni][nj] = true;
                    q.offer(new Node(ni, nj));
                }
            }
        }
    }
}