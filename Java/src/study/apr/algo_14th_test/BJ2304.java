package study.apr.algo_14th_test;

import java.io.*;
import java.util.*;

public class BJ2304 {
    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        Node[] arr = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x, y);
        }
        Arrays.sort(arr);

        int idx = 0;
        int sum = 0;
        // 상승
        for (int i = 1; i < N; i++) {
            if (arr[i].y > arr[idx].y) {
                sum += (arr[i].x - arr[idx].x) * (arr[idx].y);
                idx = i;
            }
        }
        // 최고 높이 지점
        sum += arr[idx].y;
        // 하강
        while (idx < N - 1) {
            if (arr[idx].y == arr[idx + 1].y) { // 같은 경우
                sum += (arr[idx + 1].x - arr[idx].x) * (arr[idx].y);
                idx++;
            }
            else { // 작은 경우 (큰 경우 존재 x)
                int idx2 = idx + 1;
                for (int j = idx + 1; j < N - 1; j++) {
                    if (arr[idx2].y < arr[j + 1].y) idx2 = j + 1;
                }
                sum += (arr[idx2].x - arr[idx].x) * (arr[idx2].y);
                idx = idx2;
            }
        }
        System.out.println(sum);
    }
}