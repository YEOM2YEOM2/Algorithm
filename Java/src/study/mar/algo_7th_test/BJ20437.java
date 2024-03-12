package study.mar.algo_7th_test;

import java.io.*;

public class BJ20437 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] strCnt = new int[26];
            for (int i = 0; i < str.length(); i++) strCnt[str.charAt(i) - 'a']++;

            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int i = 0; i < str.length(); i++) {
                if (strCnt[str.charAt(i) - 'a'] < K) continue;

                int cnt = 1;
                for (int j = i + 1; j <str.length(); j++) { // str 순서대로 탐색함으로 시작 인덱스를 알고 있음.
                    if (str.charAt(i) == str.charAt(j)) cnt++;
                    if (cnt == K) { // 탐색 범위 안에 정확히 해당 글자를 K개 포함하고 있어야하기 때문에 cnt가 K에 도달하면 break
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(min + " " + max);
        }
    }
}
