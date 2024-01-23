import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class BJ4863 {
    static int arr[][];
    static boolean visited[][];
    static int di[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int dj[] = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int h, w;

    static class Node {
        int ci;
        int cj;

        public Node(int i, int j) {
            this.ci = i;
            this.cj = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static void bfs(int si, int sj) {
        Queue<Node> q = new LinkedList<Node>();
        visited[si][sj] = true;
        q.offer(new Node(si, sj));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 8; i++) {
                int ni = node.ci + di[i];
                int nj = node.cj + dj[i];

                if (0 <= ni && ni < h && 0 <= nj && nj < w && !visited[ni][nj] && arr[ni][nj] == 1) {
                    visited[ni][nj] = true;
                    q.offer(new Node(ni, nj));
                }
            }
        }
    }
}
