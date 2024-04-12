package study.apr.algo_12th_test;

import java.io.*;
import java.util.*;

public class BJ1863 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());

        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().strip());
            int no = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                if (y != 0) { // 첫 번째 빌딩의 높이가 0인 경우 처리
                    ans++;
                    stack.add(y);
                }
            } else {
                if (stack.peek() < y) {
                    ans++;
                    stack.add(y);
                } else {
                    while (!stack.isEmpty() && stack.peek() > y) stack.pop(); // y = 0일 경우 stack이 비게 됨.
                    if (!stack.isEmpty()) {
                        if (stack.peek() < y) {
                            ans++;
                            stack.add(y);
                        }
                    } else {
                        if (y > 0) {
                            ans++;
                            stack.add(y);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
