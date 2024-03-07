import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int[] cnt = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int left = 0;
        int right = 0;
        while (right < N) {
            while (right < N && cnt[nums[right]] < K) {
                cnt[nums[right]]++;
                right++;
            }

            int len = right - left;
            ans = Math.max(ans, len);
            cnt[nums[left]]--;
            left++;
        }

        System.out.println(ans);
    }
}