package study.may.algo_17th_test;

import java.io.*;
import java.util.*;

public class BJ1941 {
    static int ans;
    static boolean[][] arr = new boolean[5][5]; // true: 이다솜파, false: 임도연파
    static int[] order = new int[7];

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            String temp = br.readLine().strip();
            for (int j = 0; j < 5; j++) if (temp.charAt(j) == 'S') arr[i][j] = true;
        }
        comb(0, 0, 0);
        System.out.println(ans);
    }

    private static void comb(int cntY, int s, int k) { // n : 이다솜파 학생 수
        if (cntY >= 4) return; // 임도연파가 4명이상 선택되면 return

        if (k == 7) { // 7개 선정
            solution();
            return;
        }

        for (int i = s; i < 25; i++) {
            order[k] = i;
            if (arr[i / 5][i % 5]) comb(cntY, i + 1, k + 1); // 이다솜파 학생 추가
            else comb(cntY + 1, i + 1, k + 1); // 임도연파 학생 추가
        }
    }

    private static void solution() {
        boolean[] visited = new boolean[7];
        Queue<int[]> q = new LinkedList<>();
        visited[0] = true;
        q.offer(new int[] {order[0] / 5, order[0] % 5});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];

            for (int k = 0; k < 4; k++) {
                int ni = ci + di[k];
                int nj = cj + dj[k];
                int idx = ni * 5 + nj; // 2차원 배열 idx -> 1차원 배열 idx
                if (0 <= ni && ni < 5 && 0 <= nj && nj < 5) {
                    // 선정된 7개가 모두 연결되는지 확인
                    for (int i = 0; i < 7; i++) {
                        /*
                        아직 연결되지 않았고, order[i]의 1차원 idx값이 idx와 동일
                        == 현재 좌표의 상하좌우 인접한 영역
                         */
                        if (!visited[i] && order[i] == idx) {
                            q.offer(new int[] {ni, nj});
                            visited[i] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 7; i++) if (!visited[i]) return;
        ans++;
    }
}