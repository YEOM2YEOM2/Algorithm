package study.may.algo_16th_test;

import java.io.*;
import java.util.*;

public class BJ1052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[24]; // 2의 제곱 배열

        int temp = 1;
        for (int i = 0; i < 24; i++) {
            arr[i] = temp;
            temp *= 2;
        }

        int n = N;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < 24; i++) {
                if ((arr[i] & n) > 0) cnt++;
            }

            if (cnt <= K) break; // 1의 개수가 K 이하라면 while문 탈출
            n++;
        }
        System.out.println(n - N);
    }
}