package study.feb.algo_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ19939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans;
        int temp = K * (1 + K) / 2;
        if (N < temp) {
            ans = -1;
        } else {
            if ((N - temp) % K == 0) {
                ans = K - 1;
            } else {
                ans = K;
            }
        }
        System.out.println(ans);
    }
}
