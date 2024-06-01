import java.io.*;
import java.util.*;

public class Main {
    static String s;
    static StringBuilder t = new StringBuilder();

    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().strip();
        t.append(br.readLine().strip());

        int cntAS = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == 'A') cntAS++;

        int cntAT = 0;
        for (int i = 0; i < t.length(); i++) if (t.charAt(i) == 'A') cntAT++;

        int diffA = cntAT - cntAS;
        int diffB = (t.length() - cntAT) - (s.length() - cntAS);
        if (diffA < 0 || diffB < 0) { // 추가 연산만 가능
            System.out.println(0);
            return;
        };

        perm(diffA, diffB, diffA + diffB);

        if (isPossible) System.out.println(1);
        else System.out.println(0);
    }

    private static void perm(int diffA, int diffB, int k) {
        if (isPossible) return;

        if (k == 0) {
            if (t.toString().equals(s)) isPossible = true;
            return;
        }

        if (diffA > 0 && t.charAt(t.length() - 1) == 'A') {
            t.delete(t.length() - 1, t.length());
            perm(diffA - 1, diffB, k - 1);
            t.append('A');
        }

        if (diffB > 0 && t.charAt(0) == 'B') {
            t.delete(0, 1);
            t.reverse();
            perm(diffA, diffB - 1, k - 1);
            t.append('B');
            t.reverse();
        }
    }
}