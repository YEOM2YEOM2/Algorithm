package study.algo_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3020 {
    static int N, H;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H];

        for (int k = 0; k < N; k++) {
            int temp = Integer.parseInt(br.readLine());
            if (k % 2 == 0) {
                for (int i = H - 1; i > H - 1- temp; i--) arr[i]++;
            } else {
                for (int i = 0; i < temp; i++) arr[i]++;
            }
        }

        int ans = arr[1];
        int cnt = 1;
        for (int i = 1; i < H; i++) {
            if (arr[i] < ans) {
                ans = arr[i];
                cnt = 1;
            } else if (ans == arr[i]) {
                cnt++;
            }
        }
        System.out.print(ans + " " + cnt);
    }
}