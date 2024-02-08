package study.algo_3rd;

import java.io.*;
import java.util.*;

// 이분탐색
public class BJ10816_BS {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            // key에 해당하는 값이 arr의 가장 작은 idx값과 가장 큰 idx값의 차이를 구함.
            sb.append(upperIdx(key) - lowerIdx(key)).append(" ");
        }
        System.out.println(sb);
    }

    private static int lowerIdx(int key) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (key <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int upperIdx(int key) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (key < arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
