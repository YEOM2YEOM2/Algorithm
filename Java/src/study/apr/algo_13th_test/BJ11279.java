package study.apr.algo_13th_test;

import java.io.*;
import java.util.*;

public class BJ11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine().strip());

            if (num == 0) {
                if (maxHeap.isEmpty()) System.out.println(0);
                else System.out.println(maxHeap.poll());
            } else {
                maxHeap.add(num);
            }
        }
    }
}
