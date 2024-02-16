package study.feb.algo_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3020_BS {
    static int N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 항상 짝수
        H = Integer.parseInt(st.nextToken());
        int[] bottom = new int[N / 2]; // 석순
        int[] top = new int[N / 2]; // 종유석

        for (int i = 0; i < N / 2; i++) {
            int b = Integer.parseInt(br.readLine());
            int t = Integer.parseInt(br.readLine());
            bottom[i] = b;
            top[i] = t;
        }

        Arrays.sort(bottom);
        Arrays.sort(top);

        int min = N;
        int cnt = 0;
        for (int i = 1; i < H + 1; i++) {
            int temp = binarySearch(i, bottom) + binarySearch(H - i + 1, top);

            if (temp < min) {
                min = temp;
                cnt = 1;
            } else if (temp == min) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);


    }

    private static int binarySearch(int key, int[] arr) {
        int left = 0;
        int right = N / 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - right;
    }
}