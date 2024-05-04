import java.io.*;
import java.util.*;

public class Main {
    static class City {
        int p; // 주유쇼 리터당 가격
        int d; // 오른쪽의 인접한 도시까지의 거리

        public City(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        City[] cities = new City[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine().strip()); // 거리
        StringTokenizer st2 = new StringTokenizer(br.readLine().strip()); // 리터당 가격
        for (int i = 0; i < N - 1; i++) {
            cities[i] = new City(Integer.parseInt(st2.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int idx = 0; // 현재 도시 위치
        int ans = 0;
        while (idx < N - 1) {
            int tempIdx = idx;
            for (int i = idx + 1; i < N - 1; i++) {
                if (cities[idx].p <= cities[i].p) tempIdx = i;
                else break;
            }

            for (int i = idx; i <= tempIdx; i++) {
                ans += cities[idx].p * cities[i].d;
            }

            idx = tempIdx + 1;
        }
        System.out.println(ans);
    }
}