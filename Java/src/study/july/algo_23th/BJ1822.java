package study.july.algo_23th;

import java.io.*;
import java.util.*;

public class BJ1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());
        int[] ans = new int[nA];

        HashMap<Integer, Integer> hash = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (!hash.containsKey(temp)) hash.put(temp, 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (hash.containsKey(temp)) hash.put(temp, hash.get(temp) + 1);
        }

        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() == 1) {
                ans[idx] = entry.getKey();
                idx++;
            }
        }

        if (ans[0] == 0) System.out.println(0);
        else {
            Arrays.sort(ans);
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nA; i++) {
                if (ans[i] != 0) {
                    sb.append(ans[i] + " ");
                    cnt++;
                }
            }
            System.out.println(cnt);
            System.out.println(sb);
        }
    }
}