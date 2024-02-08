package study.algo_3rd;

import java.util.*;
import java.io.*;

// 메모리 초과
public class BJ3020_X {
    static int N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H][N];
        for (int t = 0; t < N; t++) {
            int temp = Integer.parseInt(br.readLine());
            if (t % 2 == 0) {
                for (int i = H - 1; i > H - 1 - temp; i--) arr[i][t] = 1;
            } else  {
                for (int i = 0; i < temp; i++) arr[i][t] = 1;
            }
        }

        int ans = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    temp++;
                }
            }

            if (temp < ans) {
                ans = temp;
                cnt = 1;
            } else if (temp == ans) {
                cnt++;
            }
        }
        System.out.print(ans + " ");
        System.out.println(cnt);
    }
}