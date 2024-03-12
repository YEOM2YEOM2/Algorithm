package study.mar.algo_7th_test;

import java.io.*;
import java.util.*;

public class BJ2179 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) words[i] = br.readLine();

        int idx1 = 0;
        int idx2 = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            String word1 = words[i];
            for (int j = i + 1; j < N; j++) {
                String word2 = words[j];
                int cnt = 0;
                int length = word1.length() < word2.length() ? word1.length() : word2.length();

                for (int k = 0; k < length; k++) {
                    if (word1.charAt(k) == word2.charAt(k)) cnt++;
                    else break;
                }

                if (max < cnt) {
                    max = cnt;
                    idx1 = i;
                    idx2 = j;
                }
            }
        }
        System.out.println(words[idx1]);
        System.out.println(words[idx2]);
    }
}
