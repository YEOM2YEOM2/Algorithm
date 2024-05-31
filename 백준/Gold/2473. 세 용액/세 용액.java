import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long max = Long.MAX_VALUE;
    static int[] arr;
    static int[] pick = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for (int i = 0; i < N - 2; i++) twoPointer(i);

        for (int i = 0; i < 3; i++) System.out.print(pick[i] + " ");
    }

    private static void twoPointer(int idx) {
        int s = idx + 1;
        int e = N - 1;

        while (s < e) {
            long sum = (long )arr[s] + arr[e] + arr[idx];
            long absSum = Math.abs(sum);

            if (absSum < max) {
                pick[0] = arr[idx];
                pick[1] = arr[s];
                pick[2] = arr[e];
                max = absSum;
            }

            if (sum > 0) e--;
            else s++;
        }
    }
}