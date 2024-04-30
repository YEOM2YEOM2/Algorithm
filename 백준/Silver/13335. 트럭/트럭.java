import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int w;
        int t;

        public Node(int w, int t) {
            this.w = w;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine().strip());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int t = 0;
        int idx = 0;
        Deque<Node> deque = new ArrayDeque<>();

        while (idx < N) {
            int sum = 0;
            for (Node node : deque) sum += node.w;

            if (deque.size() <= W && sum + arr[idx] <= L) { // 다리에 최대로 올라갈 수 있는 트럭 수와 다리 위의 트럭들의 하중이 최대하중보다 작을 경우
                deque.add(new Node(arr[idx], W));
                idx++;
            }

            for (Node node : deque) node.t--;
            if (deque.getFirst().t == 0) deque.removeFirst();

            t++;
        }

        t += W;
        System.out.println(t);
    }
}