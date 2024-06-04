package study.jun.algo_20th;

import java.io.*;
import java.util.*;

// StringBuilder 사용 -> 55% 시간 초과
public class BJ1406_SB_X {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Character> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        String input = st.nextToken();
        for (char c : input.toCharArray()) list.add(c);

        int M = Integer.parseInt(br.readLine().strip());
        int idx = list.size() - 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().strip());
            char option = st.nextToken().charAt(0);

            if (option == 'L') {
                if (idx > -1) idx--;
            } else if (option == 'D') {
                if (idx < list.size() - 1) idx++;
            } else if (option == 'B') {
                if (idx != -1) {
                    list.remove(idx);
                    idx--;
                }
            } else { // P
                char word = st.nextToken().charAt(0);
                list.add(idx + 1, word);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : list) sb.append(c);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}