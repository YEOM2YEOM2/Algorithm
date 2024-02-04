package study.algo_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            arr[i][0] = Math.min(arr[i-1][1] + arr[i][0], arr[i-1][2] + arr[i][0]);
            arr[i][1] = Math.min(arr[i-1][0] + arr[i][1], arr[i-1][2] + arr[i][1]);
            arr[i][2] = Math.min(arr[i-1][0] + arr[i][2], arr[i-1][1] + arr[i][2]);
        }

        int ans = 987654321;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, arr[N - 1][i]);
        }
        System.out.println(ans);
    }
}
