import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 40; i++) dp[i] = dp[i - 2] + dp[i - 1];

        int ans = 1;
        int pre = 1;
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(br.readLine());
            ans *= dp[n - pre];
            pre = n + 1;
        }
        ans *= dp[N - pre + 1];

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}