import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static int[] rep;

    static class Node implements Comparable<Node> {
        int a;
        int b;
        int c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        rep = new int[V + 1];

        for (int i = 1; i <= V; i++) rep[i] = i;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 가중치

            pq.offer(new Node(a, b, c));
        }

        int s = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (findSet(node.a) != findSet(node.b)) {
                cnt++;
                s += node.c;
                union(node.a, node.b);
            }

            if (cnt == V - 1) break;
        }
        System.out.println(s);
    }

    private static int findSet(int x) {
        while (x == rep[x]) return x;
        return rep[x] = findSet(rep[x]);
    }

    private static void union(int x, int y) { // y의 대표 원소의 대표 원소를 x가 속해있는 집단의 대표 원소로 교체
        rep[findSet(y)] = findSet(x);
    }
}