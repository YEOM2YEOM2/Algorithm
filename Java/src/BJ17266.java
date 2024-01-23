import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17266 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] locations = new int[m];

        for (int i = 0; i < m; i++) {
            locations[i] = Integer.parseInt(st.nextToken());
        }

        // 완탐 100,000 * 100,000 시간 초과 → 이분 탐색
        int ans = 1;
        int minHeight = 1;
        int maxHeight = n;
        while (minHeight <= maxHeight) {
            int midHeight = (minHeight + maxHeight) / 2;
            boolean flag = true;

            // midHeight로 굴다리를 모두 비출 수 있는지 확인
            int prev = 0; // 마지막으로 가로등이 비춘 위치
            for (int i = 0; i < m; i++) {
                if (locations[i] - midHeight <= prev) {
                    prev = locations[i] + midHeight;
                } else {
                    flag = false;
                }
            }

            if (n - prev > 0) flag = false;

            if (flag) {
                ans = midHeight;
                maxHeight = midHeight - 1;
            } else { // 현재 midHeight로는 굴다리를 다 비출 수 없음.
                minHeight = midHeight + 1;
            }
        }
        System.out.println(ans);

    }
}