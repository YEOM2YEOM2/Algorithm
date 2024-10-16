import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().strip();
        StringBuilder sb = new StringBuilder();
        String word1 = "AAAA";
        String word2 = "BB";
        int cnt = 1;
        if (input.length() < 2) {
            if (input.charAt(0) == 'X') System.out.println(-1);
            else System.out.println('.');
            return;
        }

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) == input.charAt(i)) cnt++;
            else {
                if (input.charAt(i - 1) == 'X') {
                    if (cnt % 2 == 0) {
                        for (int j = 0; j < cnt / 4; j++) sb.append(word1);
                        for (int j = 0; j < (cnt - cnt / 4 * 4) / 2; j++) sb.append(word2);
                    } else {
                        System.out.println(-1);
                        return;
                    }
                } else {
                    for (int j = 0; j < cnt; j++) sb.append('.');
                }
                // cnt 초기화
                cnt = 1;
            }
        }

        if (input.charAt(input.length() - 1) == 'X') {
            if (cnt % 2 == 0) {
                for (int j = 0; j < cnt / 4; j++) sb.append(word1);
                for (int j = 0; j < (cnt - cnt / 4 * 4) / 2; j++) sb.append(word2);
            } else {
                System.out.println(-1);
                return;
            }
        } else {
            for (int j = 0; j < cnt; j++) sb.append('.');
        }
        System.out.println(sb.toString());
    }
}