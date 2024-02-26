package study.feb.algo_3rd_binary_search;

import java.io.*;
import java.util.StringTokenizer;

// 카운팅 정렬
public class BJ10816_C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] plusCount = new int[10000001];
        int[] minusCount = new int[10000001];

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp >= 0) {
                plusCount[temp]++;
            } else {
                minusCount[-temp]++;
            }
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp >= 0) {
                sb.append(plusCount[temp] + " ");
            } else {
                sb.append(minusCount[-temp] + " ");
            }
        }

        System.out.println(sb);
    }
}
