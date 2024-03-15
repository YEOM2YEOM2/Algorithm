package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15894 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1 <= n <= 10^9(10억) → 4 * 10억 = 40억 int 범위를 벗어남. → long 사용
        int n = Integer.parseInt(st.nextToken());
        long length = (long) n * 4;
        System.out.println(length);
    }
}
