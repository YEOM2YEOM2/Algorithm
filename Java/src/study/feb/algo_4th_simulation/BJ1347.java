package study.feb.algo_4th;

import java.io.*;

public class BJ1347 {
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
        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[2 * N + 1][2 * N - 1];

        String temp = br.readLine();
        Node node = new Node(N, N - 1);
        visited[N][N - 1] = true;
        int dir = 52; // 0:남 1:서 2:북 3:동
        int minI = node.i;
        int maxI = node.i;
        int minJ = node.j;
        int maxJ = node.j;
        for (int i = 0; i < N; i++) {
            if (temp.charAt(i) == 'R') {
                dir++;
            } else if (temp.charAt(i) == 'L') {
                dir--;
            } else {
                if (dir % 4 == 0) {
                    node.i++;
                    maxI = Math.max(maxI, node.i);
                } else if (dir % 4 == 1) {
                    node.j--;
                    minJ = Math.min(minJ, node.j);
                } else if (dir % 4 == 2) {
                    node.i--;
                    minI = Math.min(minI, node.i);
                } else {
                    node.j++;
                    maxJ = Math.max(maxJ, node.j);
                }
                visited[node.i][node.j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minI; i <= maxI; i++) {
            for (int j = minJ; j <= maxJ; j++) {
                if (visited[i][j]) {
                    sb.append('.');
                } else {
                    sb.append('#');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
