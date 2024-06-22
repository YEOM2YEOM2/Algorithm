package study.jun.algo_22th;

import java.io.*;
import java.util.*;

public class BJ17140 {
    static int[][] arr = new int[101][101];

    static class Node implements Comparable<Node> {
        int n;
        int cnt;

        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt == o.cnt) return this.n - o.n;
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= 100; i++) Arrays.fill(arr[i], -1);

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine().strip());
            for (int j = 1; j <= 3; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        while (true) {
            if (arr[r][c] == k) break;
            if (time > 100) break;

            int row = 0; int column = 0;
            for (int i = 1; i <= 101; i++) {
                if (arr[i][1] != -1) row++;
                else break;
            }

            for (int j = 1; j <= 101; j++) {
                if (arr[1][j] != -1) column++;
                else break;
            }

            if (row >= column) R();
            else C();

            time++;
        }

        time = time > 100 ? -1 : time;
        bw.write(time + "\n");
        bw.flush();
        bw.close();
    }

    private static void R() {
        int row = 0; int max = 0;
        List<Integer> index = new ArrayList<>();
        index.add(-1);
        for (int i = 1; i <= 100; i++) {
            if (arr[i][1] != -1) {
                // 각 행 카운팅
                int[] count = new int[101];
                for (int j = 1; j <= 100; j++) {
                    if (arr[i][j] != -1) count[arr[i][j]]++;
                    else break;
                }
                // count 오름차순, number 오름차순 정렬
                PriorityQueue<Node> pq = new PriorityQueue<>();
                for (int k = 1; k <= 100; k++) if (count[k] > 0) pq.offer(new Node(k, count[k]));

                index.add(pq.size() * 2);
                max = Math.max(max, pq.size() * 2);
                int idx = 1;
                while (!pq.isEmpty() && idx <= 100) {
                    Node node = pq.poll();

                    arr[i][idx] = node.n;
                    arr[i][idx + 1] = node.cnt;

                    idx += 2;
                }
            } else {
                row = i - 1;
                break;
            }
        }
        // max를 이용해 0 채우기
        for (int i = 1; i <= row; i++) {
            for (int j = index.get(i) + 1; j <= max; j++) arr[i][j] = 0;
            for (int j = max + 1; j <= 100; j++) arr[i][j] = -1;
        }
    }

    private static void C() {
        int column = 0; int max = 0;
        List<Integer> index = new ArrayList<>();
        index.add(-1);
        for (int j = 1; j <= 100; j++) {
            if (arr[1][j] != -1) {
                // 각 열 카운팅
                int[] count = new int[101];
                for (int i = 1; i <= 100; i++) {
                    if (arr[i][j] != -1) count[arr[i][j]]++;
                    else break;
                }
                // count 오름차순, number 오름차순 정렬
                PriorityQueue<Node> pq = new PriorityQueue<>();
                for (int k = 1; k <= 100; k++) if (count[k] > 0) pq.offer(new Node(k, count[k]));

                index.add(pq.size() * 2);
                max = Math.max(max, pq.size() * 2);
                int idx = 1;
                while (!pq.isEmpty() && idx <= 100) {
                    Node node = pq.poll();

                    arr[idx][j] = node.n;
                    arr[idx + 1][j] = node.cnt;

                    idx += 2;
                }
            } else {
                column = j - 1;
                break;
            }
        }
        // max를 이용해 0 채우기
        for (int j = 1; j <= column; j++) {
            for (int i = index.get(j) + 1; i <= max; i++) arr[i][j] = 0;
            for (int i = max + 1; i <= 100; i++) arr[i][j] = -1;
        }
    }
}