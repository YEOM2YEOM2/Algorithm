import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        long temp = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            temp += arr[i];
            max = Math.max(arr[i], max);
        }

        long M = Integer.parseInt(br.readLine().strip()); // 총 예산

        if (temp <= M) System.out.println(max);
        else {
            int left = 0;
            int right = 100_000;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                long sum = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i] <= mid) sum += arr[i];
                    else sum += mid;
                }

                if (sum <= M) left = mid + 1;
                else right = mid - 1;
            }
            System.out.println(right);
        }
    }
}