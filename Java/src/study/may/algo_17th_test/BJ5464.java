package study.may.algo_17th_test;

import java.io.*;
import java.util.*;

public class BJ5464 {
    static int ans, N, M;
    static int[] w;

    static class ParkingLot {
        int fee;
        int isParked;

        public ParkingLot (int fee) {
            this.fee = fee;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ParkingLot[] p = new ParkingLot[N];
        w = new int[M + 1];
        for (int i = 0; i < N; i++) p[i] = new ParkingLot(Integer.parseInt(br.readLine().strip()));
        for (int i = 1; i <= M; i++) w[i] = Integer.parseInt(br.readLine().strip());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 2 * M; i++) {
            int n = Integer.parseInt(br.readLine().strip());

            if (n > 0) park(n, p, q);
            else move(n, p, q);
        }

        System.out.println(ans);
    }

    private static void park(int n, ParkingLot[] p, Queue<Integer> q) { // 주차
        boolean flag = false; // 차량이 주차되었는지 판단
        for (int i = 0; i < p.length; i++) {
            if (p[i].isParked == 0) { // 주차 x
                p[i].isParked = n;
                flag = true;
                break;
            }
        }

        if (!flag) q.offer(n);
    }

    private static void move(int n, ParkingLot[] p, Queue<Integer> q) {
        int absN = Math.abs(n);
        for (int i = 0; i < p.length; i++) {
            if (p[i].isParked == absN) {
                ans += p[i].fee * w[absN];
                // 대기하는 차량이 있는지 없는지 분기
                if (!q.isEmpty()) p[i].isParked = q.poll();
                else p[i].isParked = 0;

                break;
            }
        }
    }
}