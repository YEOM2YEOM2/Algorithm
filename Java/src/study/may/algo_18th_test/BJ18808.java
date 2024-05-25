package study.may.algo_18th_test;

import java.io.*;
import java.util.*;

public class BJ18808 {
    static int N, M, K;
    static boolean[][] visited;
    static ArrayList<boolean[][]> stickers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M]; // 노트북 N * M 크기

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine().strip());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[][] temp = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().strip());
                for (int j = 0; j < m; j++) if (Integer.parseInt(st.nextToken()) == 1) temp[i][j] = true;
            }
            stickers.add(temp);
        }
        System.out.println(solution());
    }

    private static int solution() {
        int sum = 0;
        for (int k = 0; k < K; k++) {
            if (add(k)) continue;

            for (int l = 0; l < 3; l++) {
                rotate(k);
                if (add(k)) break;
            }
        }

        // 스티커 다 붙은 후 노트북 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) if (visited[i][j]) sum++;
        }
        return sum;
    }

    private static void rotate(int idx) {
        boolean[][] sticker = stickers.get(idx);
        boolean[][] temp = new boolean[sticker[0].length][sticker.length];

        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j]) temp[j][sticker.length - 1 - i] = true;
            }
        }
        stickers.set(idx, temp);
    }

    private static boolean add(int idx) {
        boolean[][] sticker = stickers.get(idx);

        for (int i = 0; i <= N - sticker.length; i++) {
            for (int j = 0; j <= M - sticker[0].length; j++) {
                if (isPossible(idx, i, j)) { // 스티커 붙이기
                    int ci = 0;
                    for (int k = i; k < i + sticker.length; k++) {
                        int cj = 0;
                        for (int l = j; l < j + sticker[0].length; l++) {
                            if (sticker[ci][cj]) visited[k][l] = true;
                            cj++;
                        }
                        ci++;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPossible(int idx, int si, int sj) {
        boolean[][] sticker = stickers.get(idx);

        int ci = 0;
        for (int i = si; i < si + sticker.length; i++) {
            int cj = 0;
            for (int j = sj; j < sj + sticker[0].length; j++) {
                if (sticker[ci][cj] && visited[i][j]) return false; // 스티커도 놓아야 하는데 이미 다른 스티커가 놓여져있음.
                cj++;
            }
            ci++;
        }

        return true;
    }
}