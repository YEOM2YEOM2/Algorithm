import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static boolean isComplete = false;
    static int[][] arr = new int[9][9];

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
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) K++;
            }
        }
        dfs(0);
    }

    private static void dfs(int k) {
        if (isComplete) return;

        if (k == K) {
            isComplete = true;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) sb.append(arr[i][j] + " ");
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 0) {
                    Node node = new Node(i, j);
                    boolean[] visited = new boolean[10];
                    row(node, visited);
                    column(node, visited);
                    square(node, visited);

                    for (int n = 1; n < 10; n++) {
                        if (!visited[n]) {
                            arr[i][j] = n;
                            dfs(k + 1);
                            arr[i][j] = 0;
                        }
                    }
                    return; // dfs() 넘어가지 못 했으면 이전 0 위치로 돌아가서 숫자 다시 골라야 함.
                }
            }
        }
    }

    private static void row(Node node, boolean[] visited) { // 가로
        for (int j = 0; j < 9; j++) visited[arr[node.i][j]] = true;
    }

    private static void column(Node node, boolean[] visited) { // 세로
        for (int i = 0; i < 9; i++) visited[arr[i][node.j]] = true;
    }

    private static void square(Node node, boolean[] visited) { // 3 * 3
        int si = node.i / 3 * 3;
        int sj = node.j / 3 * 3;
        for (int i = si; i < si + 3; i++) {
            for (int j = sj; j < sj + 3; j++) visited[arr[i][j]] = true;
        }
    }
}