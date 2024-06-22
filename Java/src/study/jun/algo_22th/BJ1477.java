package study.jun.algo_22th;

import java.io.*;
import java.util.*;

// 백준 공유기 설치 문제와 유사
public class BJ1477 {
    static int N, M, L;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr.add(0);
        arr.add(L);

        st = new StringTokenizer(br.readLine().strip());
        for (int i = 0; i < N; i++) arr.add(Integer.parseInt(st.nextToken()));
        Collections.sort(arr);
        /*
        0 99 100
        left    0  0  0  0 0 0
        mid    50 24 12  5 2 0  -> zero division 발생
        right 100 49 23 11 4 1
         */
        int left = 1; // 초기값 0, zero division 발생
        int right = L;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < arr.size() - 1; i++) {
                // 새로운 주유소를 설치할 수 있는 곳은 현재 인덱스와 다음 인덱스를 제외한 부분이기 때문에 -1 필요
                cnt += (arr.get(i + 1) - arr.get(i) - 1) / mid;
            }
            /*
            새로 세운 주유소의 개수 > 설치할 수 있는 주요소의 개수
            -> 새로 세운 주유소의 수를 줄여야 함. 주유소 설치 최대 거리 늘려 주유소 개수 감소 필요
             */
            if (cnt > M) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(left);
    }
}