package study.may.algo_16th_test;

import java.io.*;
import java.util.*;

public class BJ1697 {
    static int N, K;

    static class Node {
        int x; // 현재 위치
        int cnt; // 위치까지 이동하는데 사용한 이동 횟수

        public Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[100_001];
        int[] dx = {-1, 1};
        q.offer(new Node(N, 0));

        while (!q.isEmpty()) {
            Node position = q.poll();

            if (position.x == K) {
                System.out.println(position.cnt);
                break;
            }
            // 좌우 이동
            for (int i = 0; i < dx.length; i++) {
                int nx = position.x + dx[i];
                if (isPossible(nx) && !visited[nx]) {
                    visited[nx] = true;
                    q.offer(new Node(nx, position.cnt + 1));
                }
            }
            // 순간 이동
            int nx = position.x * 2;
            if (isPossible(nx) && !visited[nx]) {
                visited[nx] = true;
                q.offer(new Node(nx, position.cnt + 1));
            }
        }
    }

    private static boolean isPossible(int x) {
        if (0 <= x && x <= 100_000) return true;
        return false;
    }
}