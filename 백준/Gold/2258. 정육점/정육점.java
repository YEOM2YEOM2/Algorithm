import java.io.*;
import java.util.*;

public class Main {

    static class Meat implements Comparable<Meat> {
        int w;
        int p;

        public Meat(int w, int p) {
            this.w = w;
            this.p = p;
        }

        // 가격 오름차순, 가격이 같을 때 무게 내림차순 정렬
        @Override
        public int compareTo(Meat o) {
            if (this.p == o.p) return o.w - this.w; // 내림차순
            return this.p - o.p; // 오름차순
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // int 범위

        Meat[] meats = new Meat[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            meats[i] = new Meat(weight, price);
        }

        Arrays.sort(meats);

        // 가격이 싼 고기만 덤으로 얻을 수 있음. → 가격이 같을 경우 금액 추가
        boolean flag = false; // 고기를 구매할 수 있는지 없는지 판단.
        int ans = Integer.MAX_VALUE;
        int cost = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) { //반복문을 끝까지 완료해야 최솟값 알 수 있음.
            sum += meats[i].w;
            // 이전 고기와 값이 같을 경우 돈을 추가로 지불해야 고기 구매 가능
            if (i > 0 && meats[i - 1].p == meats[i].p) cost += meats[i].p;
            // 비싸면 이전까지 고기 해당 돈으로 덤으로 얻을 수 있음.
            else cost = meats[i].p;

            // i 1부터 시작해서 0값을 대입하면 아래의 검증 과정이 두 번 필요함.
            if (sum >= M) {
                ans = Math.min(ans, cost);
                flag = true;
            }
        }

        if (flag) System.out.println(ans);
        else System.out.println(-1);
    }
}