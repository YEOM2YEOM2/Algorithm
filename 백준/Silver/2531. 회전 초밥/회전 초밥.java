import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine().strip());

        int max = 1;
        int[] cnt = new int[d + 1];
        // 슬라이딩윈도우 초기값
        for (int i = 0; i < k; i++) cnt[arr[i]]++;
        max = Math.max(solution(cnt, c), max);
        // 슬라이딩윈도우 이동
        for (int i = 0 ; i < N - 1; i++) {
            cnt[arr[i]]--;
            cnt[arr[(i + k) % N]]++;
            max = Math.max(solution(cnt, c), max);
        }
        System.out.println(max);
    }

    private static int solution(int[] cnt, int c) {
        int kind = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) kind++;
        }
        return cnt[c] > 0 ? kind : kind + 1;
    }
}