package study.mar.algo_9th_test;

import java.io.*;
import java.util.*;

public class BJ2109 {

    public static class Lecture implements Comparable<Lecture> {
        int p; // 가격
        int d; // 날짜

        public Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture l) { // 날짜 내림차순, 가격 내림차순
            return l.p - this.p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[10001];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.offer(new Lecture(p, d));
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();

            for (int i = lecture.d; i > 0; i--) {
                if (!visited[i]) {
                    ans += lecture.p;
                    visited[i] = true;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
