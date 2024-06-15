package study.jun.algo_21th;

import java.io.*;
import java.util.*;

public class BJ1987 {
    static int R, C, ans;
    static char[][] arr;
    static boolean[] alphabet = new boolean[26];
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine().strip();
            for (int j = 0; j < C; j++) arr[i][j] = row.charAt(j);
        }

        alphabet[arr[0][0] - 65] = true;
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int ci, int cj, int k) {
        boolean flag = false;

        for (int idx = 0; idx < 4; idx++) {
            int ni = ci + di[idx];
            int nj = cj + dj[idx];
            if (0 <= ni && ni < R && 0 <= nj && nj < C && !alphabet[arr[ni][nj] - 65]) {
                flag = true;
                alphabet[arr[ni][nj] - 65] = true;
                dfs(ni, nj, k + 1);
                alphabet[arr[ni][nj] - 65] = false;
            }
        }

        if (!flag) ans = Math.max(ans, k);
    }
}