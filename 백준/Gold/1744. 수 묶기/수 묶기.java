import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] nums = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine().trim());
        Arrays.sort(nums);

        int idx = 0;
        int ans = 0;
        for (int i = N - 1; i > 0; i--) { // nums 양수
            if (!visited[i]) {
                if (nums[i] > 1) {
                    if (nums[i - 1] > 0) {
                        if (nums[i - 1] == 1) ans += nums[i] + 1;
                        else ans += nums[i] * nums[i - 1];
                        visited[i - 1] = true;
                    } else {
                        ans += nums[i];
                    }
                } else if (nums[i] == 1) {
                    ans += 1;
                } else { // nums[i]가 0 이하인 정수인 최대 idx
                    idx = i;
                    break;
                }
                visited[i] = true;
            }
        }

        for (int i = 0; i < idx; i++) { // nums 음수, 0
            if (!visited[i]) {
                if (nums[i] < 0) {
                    if (nums[i + 1] < 0) ans += nums[i] * nums[i + 1];
                    visited[i + 1] = true;
                }
                visited[i] = true;
            }
        }
        System.out.println(visited[idx] ? ans : ans + nums[idx]);
    }
}