package study.mar.algo_8th_test;

import java.io.*;
import java.util.*;

public class BJ2493 {
    static class Tower {
        int idx;
        int h;

        public Tower(int idx, int h) {
            this.idx = idx; // pop()을 진행하기 때문에 stack.size()가 현재 몇 번 탑까지 왔는지 나타낼 수 없음.
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
            if (stack.isEmpty()) { // 시작
                sb.append("0 ");
                stack.add(new Tower(i, h));
            } else {
                while (!stack.isEmpty()) { // stack.peek(), 현재 stack.peek().h보다 큰 높이는 들어갈 수 없음.
                    if (h < stack.peek().h) { // stack.peek().h보다 작으면 stack.peek.idx 번 탑에 레이저 수신 가능
                        sb.append(stack.peek().idx + " ");
                        stack.add(new Tower(i, h));
                        break;
                    } else stack.pop(); // h가 stack.peek().h 보다 크거나 같으면 하나 꺼내고 다시 확인
                }

                if (stack.isEmpty()) { // 현재 입력으로 들어온 탑의 높이가 stack 내부의 모든 탑의 높이보다 클 때,
                    sb.append("0 ");
                    stack.add(new Tower(i, h));
                }
            }
        }
        System.out.println(sb);
    }
}
