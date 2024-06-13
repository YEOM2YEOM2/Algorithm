import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine().strip());

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = N == 1 ? 0 : 1;
        while (left < right && right < N) {
            int diff = arr[right] - arr[left];

            if (diff < M) {
                right++;
            } else if (diff == M) {
                ans = diff;
                break;
            } else {
                if (left + 1 == right && right != N - 1) right++;
                ans = Math.min(ans, diff);
                left++;
            }
        }
        System.out.println(ans);
    }
}