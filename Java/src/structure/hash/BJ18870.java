package structure.hash;

import java.io.*;
import java.util.*;

public class BJ18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        int[] origin = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken()); // 원본 배열 순서대로 출력해야해서 필요
            sorted[i] = origin[i];
        }
        Arrays.sort(sorted); // 정렬

        int cnt = 0;
        for (int n : sorted) {
            if (!hashMap.containsKey(n)) { // 중복 제거한 랭킹을 알기 위한 작업
                hashMap.put(n, cnt);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : origin) sb.append(hashMap.get(n) + " ");
        System.out.println(sb);
    }
}