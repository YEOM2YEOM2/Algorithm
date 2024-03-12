import java.io.*;
import java.util.*;

public class Main {
    static class Tower {
        int idx;
        int h;

        public Tower(int idx, int h) {
            this.idx = idx;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.add(new Tower(i, h));
            } else {
                while (!stack.isEmpty()) {
                    if (h < stack.peek().h) {
                        sb.append(stack.peek().idx + " ");
                        stack.add(new Tower(i, h));
                        break;
                    } else stack.pop();
                }

                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.add(new Tower(i, h));
                }
            }
        }
        System.out.println(sb);
    }
}