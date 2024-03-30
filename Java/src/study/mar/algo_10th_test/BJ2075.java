package study.mar.algo_10th_test;

import java.io.*;
import java.util.*;

public class BJ2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) pq.offer(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        for (int i = 0; i < N; i++) ans = pq.poll();
        System.out.println(ans);
    }
}
