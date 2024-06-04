package study.jun.algo_20th;

import java.io.*;

// 시간 초과
public class BJ17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().strip());
        for (int t = 0; t < T; t++) {
            String word = br.readLine().strip();
            StringBuilder sb = new StringBuilder(word);
            int ans = 2;

            // 회문
            if (word.equals(sb.reverse().toString())) ans = 0;
            else {
                int left = 0;
                int right = word.length() - 1;
                while (left < right) {
                    if (word.charAt(left) != word.charAt(right)) {
                        StringBuilder leftDel = new StringBuilder(word).deleteCharAt(left);
                        StringBuilder rightDel = new StringBuilder(word).deleteCharAt(right);

                        if (leftDel.toString().equals(leftDel.reverse().toString()) || rightDel.toString().equals(rightDel.reverse().toString())) ans = 1;
                        break;
                    }
                    left++;
                    right--;
                }
            }
            System.out.println(ans);
        }
    }
}