package study.jun.algo_21th;

import java.io.*;
import java.util.*;

public class BJ11559 {
    static boolean flag;
    static char[][] arr = new char[12][6];
    static int[][] visited;
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
        for (int i = 0; i < 12; i++) {
            String[] temp = br.readLine().strip().split("");
            for (int j = 0; j < 6; j++) arr[i][j] = temp[j].charAt(0);
        }

        int ans = 0;
        while (true) {
            // bfs(), 동일한 알파벳을 가지는 인접한 영역의 크기가 4 이상인 경우 삭제
            flag = false; // 터진 그룹이 존재하는지 확인
            visited = new int[12][6];
            int idx = 1;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (arr[i][j] != '.' && visited[i][j] == 0) {
                        bfs(i, j, idx);
                        idx++;
                    }
                }
            }

            if (flag) ans++;
            else break;

            down(); // 밑으로 내려주기
        }
        System.out.println(ans);
    }

    private static void bfs(int ci, int cj, int idx) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(ci, cj));
        visited[ci][cj] = idx;

        int cnt = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int k = 0; k < 4; k++) {
                int ni = node.i + di[k];
                int nj = node.j + dj[k];
                if (0 <= ni && ni < 12 && 0 <= nj && nj < 6 && visited[ni][nj] == 0 && arr[ni][nj] == arr[ci][cj]) {
                    visited[ni][nj] = idx;
                    q.offer(new Node(ni, nj));
                    cnt++;
                }
            }
        }

        if (cnt >= 4) { // 인접한 영역에 같은 글자가 4개 이상일 경우
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (visited[i][j] == idx) {
                        flag = true; // 터진 그룹 존재
                        arr[i][j] = '.';
                    }
                }
            }
        }
    }

    private static void down() {
        for (int j = 0; j < 6; j++) {
            for (int i = 10; i > -1; i--) {
                if (arr[i][j] != '.') { // 빈 칸이 아닌 경우
                    for (int k = 11; k > i; k--) {
                        if (arr[k][j] == '.') {
                            arr[k][j] = arr[i][j];
                            arr[i][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}