package study.may.algo_17th_test;

import java.io.*;
import java.util.*;

public class BJ2615 {
    static int[][] arr = new int[19][19];

    static int[] di = {-1, 1}; // 상, 하
    static int[] dj = {1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19;  i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < 19; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[3];
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (arr[i][j] != 0) {
                    boolean[] flag = new boolean[4];
                    flag[0] = row(i, j, arr[i][j]);
                    flag[1] = column(i, j, arr[i][j]);
                    flag[2] = cross(i, j, arr[i][j], 0);
                    flag[3] = cross(i, j, arr[i][j], 1);

                    for (int k = 0; k < 4; k++) {
                        if (flag[k]) {
                            if (ans[0] == 0) {
                                ans[0] = arr[i][j];
                                ans[1] = i + 1;
                                ans[2] = j + 1;
                            } else { // 검은 돌 & 흰 돌 모두 이긴 경우
                                if (ans[0] != arr[i][j]) {
                                    System.out.println(0);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (ans[0] == 0) System.out.println(0);
        else {
            System.out.println(ans[0]);
            System.out.println(ans[1] + " " + ans[2]);
        }
    }

    private static boolean row(int si, int sj, int idx) { // 1 : 검은 바둑알, 2 : 흰 바둑알
        for (int j = sj + 1; j < sj + 5; j++) if (j >= 19 || arr[si][j] != idx) return false;
        // 연속으로 6개 이상 이긴 경우 x
        if (0 <= sj - 1 && arr[si][sj - 1] == idx) return false; // 앞
        if (sj + 5 < 19 && arr[si][sj + 5] == idx) return false; // 뒤
        return true;
    }

    private static boolean column(int si, int sj, int idx) {
        for (int i = si + 1; i < si + 5; i++) if (i >= 19 || arr[i][sj] != idx) return false;
        // 연속으로 6개 이상 이긴 경우 x
        if (0 <= si - 1 && arr[si - 1][sj] == idx) return false;
        if (si + 5 < 19 && arr[si + 5][sj] == idx) return false;
        return true;
    }

    private static boolean cross(int si, int sj, int idx, int flag) {
        for (int mul = 1; mul < 5; mul++) {
            int ni = si + di[flag] * mul;
            int nj = sj + dj[flag] * mul;
            if (ni < 0 || ni >= 19 || nj < 0 || nj >= 19 || arr[ni][nj] != idx) return false;
        }
        // 연속으로 6개 이상 이긴 경우 x
        int ni = si - di[flag];
        int nj = sj - dj[flag];
        if (0 <= ni && ni < 19 && 0 <= nj && nj < 19 && arr[ni][nj] == idx) return false;

        ni = si + di[flag] * 5;
        nj = sj + dj[flag] * 5;
        if (0 <= ni && ni < 19 && 0 <= nj && nj < 19 && arr[ni][nj] == idx) return false;

        return true;
    }
}