package study.feb.algo_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2563 {
    static int N;
    static int side = 10;
    static int[][] arr = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine());
            int ti = Integer.parseInt(st.nextToken());
            int tj = Integer.parseInt(st.nextToken());

            for (int i = ti; i < ti + side; i++) {
                for (int j = tj; j < tj + side; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    ans += 1;
                }
            }
        }
        System.out.println(ans);

    }
}
