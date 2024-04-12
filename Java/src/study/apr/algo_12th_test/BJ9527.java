package study.apr.algo_12th_test;

import java.io.*;
import java.util.*;
/*
[1] https://tussle.tistory.com/1022
[2] https://degurii.tistory.com/158
 */
public class BJ9527 {
    static long[] dp = new long[55]; // 10^16 비트 길이 54

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // dp[i] = dp [i - 1] * 2 + 2^n, dp[i] : 2^i일 때 1의 개수 누적합
        dp[0] = 1; // 2^0 == 1일 때 1의 개수 누적합 1개
        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i - 1] * 2) + (1L << i);
        }// (1L << 2) int 범위를 넘어가기 때문에 1L로 선언 필요

        long ans = solution(b) - solution(a - 1);
        System.out.println(ans);
    }

    private static long solution(long n) { // 1 ~ n까지의 1의 개수의 합
        long cnt = n & 1;
        int size = (int) (Math.log(n) / Math.log(2));
        for (int i = size; i > 0; i--) {
            if ((n & (1L << i)) != 0L) {
                cnt += dp[i - 1] + (n - (1L << i) + 1);
                n -= (1L << i);
            }
        }
        return cnt;
    }
}