package study.algo_3rd;

import java.io.*;
import java.util.*;

public class BJ1654 {
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
        long right = Integer.MAX_VALUE; // right의 경우 mid가 Integer.MAX_VALUE일 때 +1이 되면 int value 초과가 되기 때문에 long으로 선언해줌.
        while (left <= right) { // <= 로 조건을 설정해야 cnt == N을 만족하는 랜선의 최대 길이가 이분 탐색이 종료되었을 때의 right에 대입됨. / < 이면 랜선의 최대 길이보다 더 큰 숫자가 도출됨.
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) cnt += arr[i] / mid;

            if (cnt < N) right = mid - 1; // cnt의 값이 N보다 작으면 오른쪽 탐색 범위 버림.
            else left = mid + 1; //cnt의 값이 N보다 크면 왼쪽 탐색 범위 버림.
        }
        return right;
    }
}
