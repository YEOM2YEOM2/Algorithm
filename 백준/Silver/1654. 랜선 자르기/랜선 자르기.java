import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for (int i = 0; i < K; i++) arr[i] = Integer.parseInt(br.readLine());

        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long left = 1;
        long right = Integer.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) cnt += arr[i] / mid;

            if (cnt < N) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}