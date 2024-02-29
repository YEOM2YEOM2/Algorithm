import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] D;
    static boolean[][] visited;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        D = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(D[i], Integer.MAX_VALUE); // d 배열 int MAX_VALUE로 초기화
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(temp[j]);
        }

        dijkstra(new Node(0, 0, 0));
        System.out.println(D[N - 1][M - 1]);
    }

    private static void dijkstra(Node start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        D[start.i][start.j] = start.d;
        pq.add(start);

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.i][node.j]) continue; // pq로 가장 가중치가 작은 순서로 뽑히기 때문에 방문했다면 이미 해당 지점까지의 최소 가중치를 구했음.
            visited[node.i][node.j] = true;
            if (node.i == N - 1 && node.j == M - 1) return;

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];

                if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]) {
                    if (D[ni][nj] > D[node.i][node.j] + arr[ni][nj]) {
                        D[ni][nj] = D[node.i][node.j] + arr[ni][nj];
                        pq.add(new Node(ni, nj, D[ni][nj]));
                    }
                }
            }
        }
    }
}