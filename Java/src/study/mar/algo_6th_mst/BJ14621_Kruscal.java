package study.mar.algo_6th_mst;

import java.io.*;
import java.util.*;

public class BJ14621_Kruscal {
    static int N, M;
    static String[] genders;
    static int[] rep;

    static class Node implements Comparable<Node> {
        int s;
        int e;
        int d;

        public Node(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        genders = br.readLine().split(" ");
        rep = new int[N + 1];
        for (int i = 0; i < N; i++) rep[i] = i;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.offer(new Node(s, e, d));
        }

        int s = 0;
        int cnt = 0;
        boolean flag = false;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (findSet(node.s) != findSet(node.e) && !genders[node.s - 1].equals(genders[node.e - 1])) { // 대표 원소가 같지 않고(연결x) 남학교와 여학교만 연결
                cnt++;
                s += node.d;
                union(node.s, node.e);
                if (cnt == N - 1) {
                    flag = true; // 경로 존재
                    break;
                }
            }
        }
        System.out.println(flag ? s : -1); // 경로가 없을 경우 -1 출력
    }

    private static int findSet(int x) {
        while (x == rep[x]) return x;
        return rep[x] = findSet(rep[x]);
    }

    private static void union(int x, int y) {
        rep[findSet(y)] = findSet(x);
    }
}
