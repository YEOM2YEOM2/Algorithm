package study.jun.algo_19th;

import java.io.*;
import java.util.*;

public class BJ2473 {
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

        for (int i = 0; i < N - 2; i++) twoPointer(i); // 세 용액이기 때문에 한 용액 좌표 고정 후 투포인터 탐색 진행

        for (int i = 0; i < 3; i++) System.out.print(pick[i] + " ");
    }

    private static void twoPointer(int idx) {
        int s = idx + 1;
        int e = N - 1;

        while (s < e) {
            /*
            (long) 없을 경우 int값의 합은 int형으로 계산됨.
            -> int형 21억 넘으면 -21억~~부터 차액 계산
            -> long형으로 전환 필요함.
             */
            long sum = (long) arr[s] + arr[e] + arr[idx];
            long absSum = Math.abs(sum);

            if (absSum < max) {
                pick[0] = arr[idx];
                pick[1] = arr[s];
                pick[2] = arr[e];
                max = absSum;
            }

            if (sum > 0) e--; // sum을 감소시켜야 함. 세 값 中 arr[e]가 최댓값 -> e--감소시킴.
            else s++; // sum을 증가시켜야 함.
        }
    }
}