package structure.stack;

import java.io.*;
import java.util.*;

public class BJ28278 { // 고속 입출력 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().strip());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (command == 2) {
                if (stack.isEmpty()) bw.write(-1 + "\n");
                else bw.write(stack.pop() + "\n");
            } else if (command == 3) {
                bw.write(stack.size() + "\n");
            } else if (command == 4) {
                if (stack.isEmpty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            } else {
                if (stack.isEmpty()) bw.write(-1 + "\n");
                else bw.write(stack.peek() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
