package study.may.algo_16th_test;

import java.io.*;
import java.util.*;

public class BJ17136 {
    static int ans = Integer.MAX_VALUE;
    static boolean[][] arr = new boolean[10][10];
    static int[] cnt = new int[6];  // 각 색종이 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(cnt, 5);

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < 10; j++) {
                if (st.nextToken().charAt(0) == '1') arr[i][j] = true;
            }
        }

        dfs(0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void dfs(int k) { // 선택한 색종이의 수 == dfs 깊이
        if (ans < k) return;
        if (isComplete()) { // 색종이를 모두 놓았는지 확인
            ans = k;
            return;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j]) {
                    for (int l = 5; l > 0; l--) {
                        if (isPossible(i, j, l)) {
                            add(i, j, l);
                            cnt[l]--;
                            dfs(k + 1);
                            cnt[l]++;
                            remove(i, j, l);
                        }
                    }
                    return; // 모든 크기의 색종이를 놓지 못했음. 이전에 놓은 색종이로 돌아가서 다른 색종이를 놓게 바로 종료
                }
            }
        }
    }
    private static boolean isComplete() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j]) return false;
            }
        }
        return true;
    }
    private static boolean isPossible(int si, int sj, int n) {
        if (si + n > 10 || sj + n > 10) return false; // 인덱스 허용 범위 밖
        if (cnt[n] == 0) return false; // 남은 색종이가 없음.

        for (int i = si; i < si + n; i++) {
            for (int j = sj; j < sj + n; j++) {
                if (!arr[i][j]) return false; // 해당 범위 내에서 하나라도 false일 경우, n * n 크기의 색종이 불가능
            }
        }
        return true;
    }

    // 색종이 추가
    private static void add(int si, int sj, int n) {
        for (int i = si; i < si + n; i++) {
            for (int j = sj; j < sj + n; j++) arr[i][j] = false;
        }
    }
    // 색종이 제거
    private static void remove(int si, int sj, int n) {
        for (int i = si; i < si + n; i++) {
            for (int j = sj; j < sj + n; j++) arr[i][j] = true;
        }
    }
}