import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine().strip());
        Arrays.sort(arr);

        int ans = 0;
        int left = 0;
        int right = arr[N - 1] - arr[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            // 첫 번째 집 무조건 공유기 설치
            int cnt = 1;
            int px = arr[0];

            for (int i = 1; i < N; i++) {
                if (arr[i] - px >= mid) {
                    cnt++;
                    px = arr[i];
                }
            }

            if (cnt >= C) {
                left = mid + 1;
                ans = mid;
            } else right = mid - 1;
        }
        System.out.println(ans);
    }
}