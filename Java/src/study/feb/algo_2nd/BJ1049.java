package study.feb.algo_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int packagePrice = 1001;
        int price = 1001;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int temp6 = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            packagePrice = temp6 < packagePrice ? temp6 : packagePrice;
            price = temp1 < price ? temp1 : price;
        }

        int ans = 0;
        int temp = price * 6;
        if (temp <= packagePrice) { // 기타줄 1개 * 6의 가격보다 패키지 가격이 비싸면 낱개로 N개 만큼 삼.
            ans = price * N;
        } else {
            ans = packagePrice * (N / 6);
            N -= N / 6 * 6;
            ans = (ans + price * N) < (ans + packagePrice) ? ans + price * N : ans + packagePrice;
        }
        System.out.println(ans);

    }
}
