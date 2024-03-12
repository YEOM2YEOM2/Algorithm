import java.io.*;
import java.util.*;

public class Main {

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

                int cnt = 1; // str 순서대로 탐색함으로 시작 인덱스를 알고 있음.
                for (int j = i + 1; j <str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j)) cnt++;
                    if (cnt == K) {
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