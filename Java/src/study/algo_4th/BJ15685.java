package study.algo_4th;

import java.io.*;
import java.util.*;

public class BJ15685 {
    static int N;
    static boolean[][] arr = new boolean[101][101]; // true : 드래곤 커브가 있는 지역, false : 드래곤 커브가 없는 지역

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            curve(x, y, d, g);
        }

        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j]) {
                    // 해당 좌표 주변 꼭짓점 3개 확인
                }
            }
        }
        System.out.println(ans);
    }

    // d : 0(→), 1(↑), 2(←), 3(↓)
    private static void curve(int x, int y, int d, int g) {
        arr[x][y] = true; // 시작점 방문 처리

    }
}
