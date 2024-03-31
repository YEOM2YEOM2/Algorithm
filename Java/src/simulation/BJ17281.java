package simulation;

import java.io.*;
import java.util.*;

public class BJ17281 {
    static int N;
    static int[][] arr;
    static int[] order = new int[10];
    static boolean[] visited = new boolean[10];

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        arr = new int[N][10];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        order[4] = 1; // 1번 선수 -> 4번 타자 고정
        visited[4] = true; // 4번 타자 정해짐.
        comb(2);
        System.out.println(ans);
    }

    private static void comb(int k) {
        if (k == 10) {
            ans = Math.max(ans, baseball());
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                order[i] = k;
                visited[i] = true;
                comb(k + 1);
                visited[i] = false;
            }
        }
    }

    private static int baseball() {
        int score = 0;
        int idx = 1; // 전 이닝 마지막 타자 번호를 기억하는 변수
        for (int i = 0; i < N; i++) { // 이닝 수
            int out = 0;
            boolean[] base = new boolean[4]; // 0 : 홈, 1 : 1루, 2: 2루, 3: 3루
            while (out < 3) {
                int batter = arr[i][order[idx]];
                if (batter == 0) {
                    out++;
                } else if (batter == 1) {
                    for (int k = 3; k >= 1; k--) {
                        if (base[k]) {
                            if (k == 3) {
                                score++;
                                base[k] = false;
                                continue;
                            }
                            base[k] = false;
                            base[k + 1] = true;
                        }
                    }
                    base[1] = true;
                } else if (batter == 2) {
                    for (int k = 3; k >= 1; k--) {
                        if (base[k]) {
                            if (k == 3 || k == 2) {
                                score++;
                                base[k] = false;
                                continue;
                            }
                            base[k] = false;
                            base[k + 2] = true;
                        }
                    }
                    base[2] = true;
                } else if (batter == 3) {
                    for (int k = 3; k >= 1; k--) {
                        if (base[k]) {
                            score++;
                            base[k] = false;
                        }
                    }
                    base[3] = true;
                } else {
                    for (int k = 3; k >= 1; k--) {
                        if (base[k]) {
                            score++;
                            base[k] = false;
                        }
                    }
                    score++;
                }

                idx++;
                if (idx == 10) idx = 1;
            }
        }
        return score;
    }
}
