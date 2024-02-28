package study.mar.algo_6th_mst;

import java.io.*;
import java.util.*;

public class BJ1647_Kruscal_PQ {
    static int N, M;
    static int[] rep;

    static class Node implements Comparable<Node> {
        int s;
        int e;
        int d; // 가중치

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
        rep = new int[N + 1];
        for (int i = 0; i < N + 1; i++) rep[i] = i;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            /*
            우선순위 큐 : 최소 힙을 구현한 자료 구조
            - 가중치가 가장 작은 원소가 항상 루트에 위치함.
            - 우선순위 큐에서 원소를 하나씩 꺼내면, 그 순간에 가장 작은 원소 반환, 모든 원소 정렬된 상태 x
             */
            pq.offer(new Node(s, e, d));
        }

        int s = 0;
        int cnt = 0;
        if (N > 2) { // N == 2일 경우 각 마을에 집 1개씩 길 만들 필요 x
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                if (findSet(node.s) != findSet(node.e)) { // 둘의 대표원소가 같지 않으면
                    cnt++;
                    s += node.d;
                    union(node.s, node.e);
                    if (cnt == N - 2) break;
                }
            }
        }
        System.out.println(s);
    }

    private static int findSet(int x) { // x가 속한 집합의 대표 원소 return
        while (x == rep[x]) return x;
        return rep[x] = findSet(rep[x]);
    }

    private static void union(int x, int y) { // y의 대표 원소가 x의 대표 원소를 가리키게 함.
        rep[findSet(y)] = findSet(x);
    }
}
