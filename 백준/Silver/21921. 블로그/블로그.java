import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 첫 번째 구간합 temp
        int temp = 0;
        for (int i = 0; i < X; i++) temp += arr[i];

        int[] visitCnt = new int[N - X + 1];
        int max = temp;
        visitCnt[0] = temp;
        for (int i = 1; i <= N - X; i++) {
            temp = temp - arr[i - 1] + arr[i + X - 1];
            visitCnt[i] = temp;
            max = Math.max(max, temp);
        }

        if (max == 0) System.out.println("SAD");
        else {
            int cnt = 0;
            for (int i = 0; i < visitCnt.length; i++) if (max == visitCnt[i]) cnt++;

            System.out.println(max);
            System.out.println(cnt);
        }
    }
}