package simulation;

import java.io.*;
import java.util.*;

public class BJ2206_3d {
    static int N, M;
    static int[][] arr;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class Node {
        int i;
        int j;
        boolean isBroken;


        public Node(int i, int j, boolean isBroken) {
            this.i = i;
            this.j = j;
            this.isBroken = isBroken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(temp[j]);
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int si, int sj) {
        Queue<Node> q = new LinkedList<>();
        /*
         벽이 부서졌는지 아닌지 판단함.
         0 : 벽을 부수지 않은 상태에서 해당 위치 지나감.
         1: 벽 부순 상태에서 해당 위치 지나감.
         */
        int[][][] visited = new int[N][M][2];

        q.add(new Node(si, sj, false));
        visited[si][sj][0] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            // 도착 시 반복문 탈출
            if (node.i == N - 1 && node.j == M - 1) {
                if (node.isBroken) return visited[N - 1][M - 1][1];
                else return visited[N - 1][M - 1][0];
            }

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];

                if (0 <= ni && ni < N && 0 <= nj && nj < M) {
                    if (node.isBroken) { // 벽을 이미 부쉈음.
                        if (arr[ni][nj] == 0 && visited[ni][nj][1] == 0) { // 벽이 아니고 방문하지 않음.
                            visited[ni][nj][1] = visited[node.i][node.j][1] + 1;
                            q.offer(new Node(ni, nj, true));
                        }
                    } else { // 벽을 부순 적 없음.
                        if (arr[ni][nj] == 1) { // 벽
                            visited[ni][nj][1] = visited[node.i][node.j][0] + 1;
                            q.offer(new Node(ni, nj, true));
                        } else if (visited[ni][nj][0] == 0) { // 길
                            visited[ni][nj][0] = visited[node.i][node.j][0] + 1;
                            q.offer(new Node(ni, nj, false));
                        }
                    }
                }
            }
        }

        return -1;
    }
}