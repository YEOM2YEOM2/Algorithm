import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine().strip());
        int[] dp = new int[21];
        dp[0] = 1;
        for (int i = 1; i < 21; i++) dp[i] = dp[i - 1] * 2;

        int idx = 0;
        for (int i = 20; i > -1; i--) {
            if (K > dp[i]) {
                idx = i + 1;
                sb.append(dp[i + 1] + " ");
                break;
            } else if (K == dp[i]) {
                idx = i;
                sb.append(dp[i] + " ");
                break;
            }
        }

        for (int i = 0; i <= idx; i++) {
            if ((K & dp[i]) > 0) {
                sb.append(idx - i);
                break;
            }
        }

        System.out.println(sb);
    }
}