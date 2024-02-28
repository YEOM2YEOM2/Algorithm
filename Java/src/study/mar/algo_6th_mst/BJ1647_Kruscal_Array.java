package study.mar.algo_6th_mst;

import java.io.*;
import java.util.*;

public class BJ1647_Kruscal_Array {
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

        List<Node> edge = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            edge.add(new Node(s, e, d));
        }
        Collections.sort(edge);

        int s = 0;
        int cnt = 0;
        if (N > 2) {
            for (Node node : edge) {
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
        /* 노드의 대표 원소를 찾기 위해 부모 노드를 따라 올라감.
        while (x != rep[x]) x = rep[x];
        return x;
         */

        // 만나는 모든 노드가 직접 대표 원소를 가리키도록 변경 → 경로 압축
        while (x == rep[x]) return x;
        return rep[x] = findSet(rep[x]);
    }

    private static void union(int x, int y) { // y의 대표 원소가 x의 대표 원소를 가리키게 함.
        rep[findSet(y)] = findSet(x);
    }
}
