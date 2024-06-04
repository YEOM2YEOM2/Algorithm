package study.jun.algo_20th;

import java.io.*;
import java.util.*;

public class BJ1406_ListIterator {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().strip();
        int N = Integer.parseInt(br.readLine().strip());
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) list.add(input.charAt(i));

        // ListIterator : 양방향 탐색 가능
        ListIterator<Character> iter = list.listIterator();
        // 처음 커서 : 문장 맨 뒤에 위치해야 함.
        while (iter.hasNext()) iter.next();

        for (int i = 0; i < N; i++) {
            String option = br.readLine().strip();
            char op = option.charAt(0);

            switch (op) {
                case 'L':
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char c = option.charAt(2);
                    iter.add(c);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : list) sb.append(c);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
