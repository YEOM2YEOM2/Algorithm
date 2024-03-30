package study.mar.algo_10th_test;

import java.io.*;
import java.util.*;

public class BJ2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = N - 1;
        int diff = Integer.MAX_VALUE;
        while (left < right) {
            int sum = Math.abs(arr[left] + arr[right]); // 두 용액의 합
            if (sum < diff) { // 0에 가까운 값을 찾는 것이기 때문에 절댓값
                sb.delete(0, sb.length());
                sb.append(arr[left] + " " + arr[right]);
                diff = sum;
            }

            if (arr[left] < 0) {
                if (arr[right] < 0) left++;
                else {
                    if (Math.abs(arr[right] + arr[left + 1]) < Math.abs(arr[right] + arr[left])) left++;
                    else right--;
                }
            } else right--;
        }
        System.out.println(sb);
    }
}