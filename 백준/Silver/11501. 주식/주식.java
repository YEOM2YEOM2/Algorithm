import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;
            int max = nums[nums.length - 1];
            for (int i = N - 2; i > -1; i--) {
                if (nums[i] < max) {
                    ans += max - nums[i]; // 주식 팔기
                } else if (nums[i] > max) {
                    max = nums[i];
                }
            }
            System.out.println(ans);
        }
    }
}