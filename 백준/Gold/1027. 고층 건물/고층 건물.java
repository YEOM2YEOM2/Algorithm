import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 1 <= N <= 50
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 0; i < N; i++) ans = Math.max(ans, check(i, arr[i]));
        System.out.println(ans);
    }

    private static int check(int x, int h) {
        int cnt = 0;
        double gradient = 1_000_000_000;
        for (int i = x - 1; i > -1; i--) {
            double temp = gradient(i, arr[i], x, h);
            if (temp < gradient) {
                cnt++;
                gradient = temp;
            }
        }

        gradient = -1_000_000_000;
        for (int i = x + 1; i < N; i++) {
            double temp = gradient(x, h, i, arr[i]);
            if (temp > gradient) {
                cnt++;
                gradient = temp;
            }
        }

        return cnt;
    }

    private static double gradient(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }
}