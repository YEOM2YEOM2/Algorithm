package study.feb.algo_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int ans = -1;
        int temp5 = N / 5;
        int temp3 = (N - temp5 * 5) / 3;
        while (temp5 >= 0) {
            if (N - temp5 * 5 - temp3 * 3 == 0) {
                ans = temp5 + temp3;
                break;
            }
            temp5 -= 1;
            temp3 = (N - temp5 * 5) / 3;
        }
        System.out.println(ans);
    }
}
