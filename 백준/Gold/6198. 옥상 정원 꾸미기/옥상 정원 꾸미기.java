import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int h;
        int idx;

        public Node(int h, int idx) {
            this.h = h;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        int[] arr = new int[N];
        int[] cnt = new int[N];

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine().strip());

        for (int i = N - 1; i > -1; i--) {
            if (stack.isEmpty()) {
                cnt[i] = 0;
            } else {
                if (stack.peek().h < arr[i]) {
                    while (!stack.isEmpty() && stack.peek().h < arr[i]) stack.pop();

                    if (stack.isEmpty()) cnt[i] = N - i - 1;
                    else cnt[i] = stack.peek().idx - i - 1;

                } else cnt[i] = 0;
            }
            stack.add(new Node(arr[i], i));
        }

        long ans = 0;
        for (int i = 0; i < N; i++) ans += cnt[i];
        System.out.println(ans);
    }
}