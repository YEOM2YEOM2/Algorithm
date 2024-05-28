import java.io.*;
import java.util.*;

public class Main {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Node implements Comparable<Node> {
        int i;
        int j;
        int d;

        public Node(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine().strip());
            if (N == 0) break;

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().strip());
                for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
            }


            System.out.println("Problem " + idx + ": " + dijkstra(N, arr));
            idx++;
        }
    }

    private static int dijkstra(int N, int[][] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        int[][] d = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(d[i], Integer.MAX_VALUE);

        pq.offer(new Node(0, 0, arr[0][0]));
        visited[0][0] = true;
        d[0][0] = arr[0][0];

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.i][node.j] = true;
            
            if (node.i == N - 1 && node.j == N - 1) break;

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                    if (d[node.i][node.j] + arr[ni][nj] < d[ni][nj]) {
                        d[ni][nj] = d[node.i][node.j] + arr[ni][nj];
                        pq.offer(new Node(ni, nj, d[ni][nj]));
                    }
                }
            }
        }
        return d[N - 1][N - 1];
    }
}