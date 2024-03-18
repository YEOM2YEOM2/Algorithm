import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1_000_001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            if (i % 3 == 0) { // 3의 배수인 경우
                if (i % 2 == 0) dp[i] = dp[i / 2]; // 6의 배수인 경우 연산(1, 2, 3) 모두 고려
                dp[i] = Math.min(dp[i / 3], Math.min(dp[i], dp[i -1])) + 1;
            } else if (i % 2 == 0) { // 2의 배수인 경우
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            } else { // 2, 3의 배수가 아닌 경우
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(dp[N]);
    }
}