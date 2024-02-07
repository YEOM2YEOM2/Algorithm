import java.io.*;
import java.util.*;

public class Main {

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
