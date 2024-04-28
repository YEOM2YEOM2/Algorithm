package study.apr.algo_14th_test;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        int[] height = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        for (int i = 1; i < N + 1; i++) {
            int n = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (cnt == n && height[j] == 0) {
                    height[j] = i;
                    break;
                }
                if (height[j] == 0) cnt++;
            }
        }

        for (int h : height) System.out.print(h + " ");
    }
}