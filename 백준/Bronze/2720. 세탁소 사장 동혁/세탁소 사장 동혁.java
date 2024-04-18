import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().strip());
        int[] coins = {25, 10, 5, 1};
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int C = Integer.parseInt(br.readLine().strip());
            for (int i = 0; i < 4; i++) {
                int cnt = C / coins[i];
                C -= coins[i] * cnt;
                sb.append(cnt + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}