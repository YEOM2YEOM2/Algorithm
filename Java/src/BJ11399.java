import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BJ11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] times = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        // 인출하는데 걸리는 시간대로 오름차순 정렬
        Arrays.sort(times);
        int total = 0;
        int csum = 0;
        for (int i = 0; i < N; i++) {
            csum += times[i]; // 1 3 6 9 13
            total += csum;
        }
        System.out.println(total);
    }
}
