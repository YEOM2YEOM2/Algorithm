package study.jun.algo_19th;

import java.io.*;
import java.util.*;

public class BJ2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        int[] parent = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine().strip());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            parent[c] = p;
        }

        System.out.println(solution(parent, x, y));
    }

    private static int solution(int[] parent, int x, int y) {
        ArrayList<Integer> xAncestors = findCommonParent(parent, x);
        ArrayList<Integer> yAncestors = findCommonParent(parent, y);
        // x, y 중 하나가 서로의 조상일 경우
        for (int i = 0; i < xAncestors.size(); i++) {
            if (xAncestors.get(i) == y) return i + 1;
        }

        for (int i = 0; i < yAncestors.size(); i++) {
            if (yAncestors.get(i)== x) return i + 1;
        }

        // x, y가 서로의 조상이 아닐 경우
        for (int i = 0; i < xAncestors.size(); i++) {
            for (int j = 0; j < yAncestors.size(); j++) {
                if (xAncestors.get(i) == yAncestors.get(j)) return i + j + 2;
            }
        }
        return -1;
    }

    private static ArrayList<Integer> findCommonParent(int[] parent, int s) {
        ArrayList<Integer> ancestor = new ArrayList<>();
        int c = s;
        while (parent[c] != 0) {
            ancestor.add(parent[c]);
            c = parent[c];
        }
        return ancestor;
    }
}