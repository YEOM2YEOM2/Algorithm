import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine().strip();
            for (int j = 0; j < M; j++) arr[i][j] = row.charAt(j);
        }

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'I') {
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (arr[node.i][node.j] == 'P') cnt++;

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && arr[ni][nj] != 'X') {
                    visited[ni][nj] = true;
                    q.offer(new Node(ni, nj));
                }
            }
        }

        if (cnt == 0) bw.write("TT");
        else bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}