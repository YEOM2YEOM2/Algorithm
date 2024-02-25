package study.feb.algo_5th;

import java.io.*;
import java.util.*;

public class BJ2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] bracket = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        int ans = 0;
        int temp = 1;
        for (int i = 0; i < bracket.length; i++) {
            if (bracket[i].equals("(")) {
                stack.push("(");
                temp *= 2;
            } else if (bracket[i].equals("[")) {
                stack.push("[");
                temp *= 3;
            } else if (bracket[i].equals(")")) {
                 if (stack.isEmpty() || !stack.peek().equals("(")) { // stack이 비었거나 짝이 맞지 않을 경우 올바르지 않음.
                     ans = 0;
                     break;
                 }

                if (bracket[i - 1].equals("(")) ans += temp;
                stack.pop();
                temp /= 2;
            } else { // ]의 경우
                if (stack.isEmpty() || !stack.peek().equals("[")) {
                    ans = 0;
                    break;
                }

                if (bracket[i - 1].equals("[")) ans += temp;
                stack.pop();
                temp /= 3;
            }
        }
        System.out.println(!stack.isEmpty() ? 0 : ans); // 반복문이 끝났는데 stack이 남아있어도 올바르지 않음.
    }
}
