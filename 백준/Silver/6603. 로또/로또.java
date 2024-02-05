import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int R = 6;
    static int[] nums;
    static int[] order = new int[R];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            // 입력 종료
            if (K == 0) break;

            nums = new int[K];
            for (int i = 0; i < K; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println();
        }
    }

    static void dfs(int k, int s) { // k : 깊이, s : 시작숫자
        if (k == R) {
            for (int num : order) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i < K - R + 1 + k; i++) {
                order[k] = nums[i];
                dfs(k + 1, i + 1);
            }
        }
    }
}