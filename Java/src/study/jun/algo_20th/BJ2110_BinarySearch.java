package study.jun.algo_20th;

import java.io.*;
import java.util.*;


// 반례들 생각하면서 종료 조건, left & right 이동 조건 설정하기
public class BJ2110_BinarySearch {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine().strip());
        Arrays.sort(arr);

        int ans = 0;
        int left = 0;
        int right = arr[N - 1] - arr[0];
        /*
        left < right; right = mid; (x)
        left <= right의 경우, 값이 역전이 되어야 while문을 탈출하기 때문에
        -> left = mid - 1; right = mid + 1; 이어야 함.
         */
        while (left <= right) {
            int mid = (left + right) / 2;
            // 첫 번째 집 무조건 공유기 설치
            int cnt = 1;
            int px = arr[0];

            for (int i = 1; i < N; i++) {
                if (arr[i] - px >= mid) { // 직전 공유기 위치와 현재 위치 차이가 mid보다 크면 공유기 설치
                    cnt++;
                    px = arr[i]; // 직전 공유기 위치 변경
                }
            }

            if (cnt >= C) {
                left = mid + 1;
                ans = mid;
            } else right = mid - 1;
        }
        System.out.println(ans);
    }
}