package study.may.algo_15th_test;

import java.io.*;
import java.util.*;

public class BJ2457 {
    static class Flower implements Comparable<Flower> {
        int s;
        int e;

        public Flower(int s, int e) {
            this.s = s;
            this.e = e;
        }
        // 시작 오름차순, 종료 내림차순
        @Override
        public int compareTo(Flower o) {
            if (this.s == o.s) return o.e - this.e;
            return this.s - o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(sm * 100 + sd, em * 100 + ed);
        }
        Arrays.sort(flowers);

        int cnt = 0; int max = 0; int idx = 0;
        int s = 301; int e = 1201;
        while (s < e) {
            boolean flag = false;

            for (int i = idx; i < N; i++) {
                // s보다 이후에 피면 의미 없음. -> 진 후 바로 피어야 함.
                if (flowers[i].s > s) break;

                if (max < flowers[i].e) {
                    flag = true;
                    max = flowers[i].e;
                    idx = i + 1;
                }
            }

            if (flag) {
                s = max;
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(max < e ? 0 : cnt);
    }
}
