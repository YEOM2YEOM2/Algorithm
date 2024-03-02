import java.io.*;
import java.util.*;

public class BJ17144 {
    static int R, C, T;
    static int[][] arr;
    static Queue<Node> q = new LinkedList<>();
    static List<Node> cleaner = new ArrayList<>();

    static int[] di = {-1, 0, 1, 0}; // 상우하좌
    static int[] dj = {0, 1, 0, -1};

    static class Node {
        int i;
        int j;
        int a; // 미세먼지 양

        public Node(int i, int j, int a) {
            this.i = i;
            this.j = j;
            this.a = a;
        }

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) cleaner.add(new Node(i, j));
            }
        }

        for (int i = 0; i < T; i++) {
            diffusionDust();
            airCleaner();
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) ans += arr[i][j];
            }
        }
        System.out.println(ans);
    }

    private static void findDust() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) q.offer(new Node(i, j, arr[i][j]));
            }
        }
    }

    private static void diffusionDust() {
        findDust();
        while (!q.isEmpty()) {
            Node node = q.poll();

            int cnt = 0; // 확산된 방향 count
            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];

                if (0 <= ni && ni < R && 0 <= nj && nj < C && arr[ni][nj] != -1) {
                    arr[ni][nj] += node.a / 5;
                    cnt++;
                }
            }
            arr[node.i][node.j] -= (node.a / 5) * cnt;
        }
    }

    private static void airCleaner() {
        // 공기 청정기 윗방향(↑ → ↓ ←)
        Node node = cleaner.get(0);
        int ci = node.i;
        int cj = node.j;

        for (int i = ci - 1; i > 0; i--) {
            arr[i][cj] = arr[i -1][cj];
            arr[i - 1][cj] = 0;

        }

        for (int j = cj; j < C - 1; j++) {
            arr[0][j] = arr[0][j + 1];
            arr[0][j + 1] = 0;
        }

        for (int i = 0; i < ci; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
            arr[i + 1][C - 1] = 0;
        }

        for (int j = C - 1; j > cj + 1; j--) {
            arr[ci][j] = arr[ci][j - 1];
            arr[ci][j -1] = 0;
        }


        // 공기 청정기 아랫방향(↓ → ↑ ←)
        node = cleaner.get(1);
        ci = node.i;
        cj = node.j;

        for (int i = ci + 1; i < R - 1; i++) {
            arr[i][cj] = arr[i + 1][cj];
            arr[i + 1][cj] = 0;
        }

        for (int j = cj; j < C - 1; j++) {
            arr[R - 1][j] = arr[R - 1][j + 1];
            arr[R - 1][j + 1] = 0;
        }

        for (int i = R - 1; i > ci; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
            arr[i - 1][C - 1] = 0;
        }

        for (int j = C - 1; j > cj + 1; j--) {
            arr[ci][j] = arr[ci][j - 1];
            arr[ci][j -1] = 0;
        }
    }
}