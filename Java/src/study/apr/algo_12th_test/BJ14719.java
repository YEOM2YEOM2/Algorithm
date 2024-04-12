package study.apr.algo_12th_test;

import java.util.*;
import java.io.*;

public class BJ14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[H][W];

        st = new StringTokenizer(br.readLine().strip());
        for (int i = 0; i < W; i++) {
            int h = Integer.parseInt(st.nextToken());
            for (int j = H - 1; j >= H - h; j--) arr[j][i] = true;
        }

        int ans = 0;
        for (int i = 0; i < H; i++) {
            boolean flag = false;
            int cnt = 0;
            for (int j = 0; j < W; j++) {
                if (flag) { // 블록을 한 번이라도 만났다면
                    if (arr[i][j]) { // 현재 위치 블록
                        ans += cnt;
                        cnt = 0;
                    } else { // 현재 위치 빈 칸
                        cnt++;
                    }
                } else { // 블록을 한 번도 만난 적 없다면
                    if (arr[i][j]) flag = true;
                }
            }
        }
        System.out.println(ans);
    }
}
