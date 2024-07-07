import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][][] visited;
    static boolean[][] arr; // true : 지나갈 수 있는 길, false : 지나갈 수 없는 길
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Node{
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        visited = new int[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++) if (row[j].charAt(0) == '0') arr[i][j] = true;
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.i == N - 1 && node.j == M - 1) return visited[N - 1][M - 1][node.cnt];

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];
                if (0 <= ni && ni < N && 0 <= nj && nj < M) {
                    // 벽, 부술 수 있음, 아직 해당 횟수로 방문한 적 x
                    if (!arr[ni][nj] && node.cnt < K && visited[ni][nj][node.cnt + 1] == 0) {
                        visited[ni][nj][node.cnt + 1] = visited[node.i][node.j][node.cnt] + 1;
                        q.offer(new Node(ni, nj, node.cnt + 1));
                    }
                    // 통로, 아직 해당 횟수로 방문한 적 x
                    if (arr[ni][nj] && visited[ni][nj][node.cnt] == 0) {
                        visited[ni][nj][node.cnt] = visited[node.i][node.j][node.cnt] + 1;
                        q.offer(new Node(ni, nj, node.cnt));
                    }
                }
            }
        }
        return -1;
    }
}