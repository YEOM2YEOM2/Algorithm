package study.mar.algo_10th_test;

import java.io.*;
import java.util.*;

public class BJ2138 {
    static int N;
    static boolean[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        boolean[] arrA = new boolean[N]; // 첫 번째 전구를 켜고 진행할 배열
        boolean[] arrB = new boolean[N]; // ----------- 켜지않고 ------
        ans = new boolean[N];

        String temp = br.readLine().strip();
        for (int i = 0; i < N; i++) {
            if (temp.charAt(i) == '1') {
                arrA[i] = true;
                arrB[i] = true;
            }
        }

        temp = br.readLine().strip();
        for (int i = 0; i < N; i++) if (temp.charAt(i) == '1') ans[i] = true;

        arrA[0] = !arrA[0];
        arrA[1] = !arrA[1];

        int ans1 = solution(arrA) + 1;
        int ans2 = solution(arrB);
        if (Math.min(ans1, ans2) == 100001) System.out.println(-1);
        else System.out.println(Math.min(ans1, ans2));
    }

    private static int solution(boolean[] arr) {
        int cnt = 0;
        for (int i = 1; i < N - 1; i++) {
            if (arr[i - 1] != ans[i - 1]) {
                arr[i - 1] = !arr[i - 1];
                arr[i] = !arr[i];
                arr[i + 1] = !arr[i + 1];
                cnt++;
            }
        }

        if (arr[N - 2] != ans[N - 2]) {
            arr[N - 2] = !arr[N - 2];
            arr[N - 1] = !arr[N - 1];
            cnt++;
        }

        if (Arrays.equals(arr, ans)) return cnt;
        else return 100001;
    }
}