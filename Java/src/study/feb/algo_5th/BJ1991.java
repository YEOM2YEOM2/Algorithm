package study.feb.algo_5th;

import java.io.*;
import java.util.*;

public class BJ1991 {
    static int N;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[N + 1][3]; // [][0] : 왼쪽 자식, [][1] : 오른쪽 자식, [][2] : 부모

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = st.nextToken().charAt(0);
            int lc = st.nextToken().charAt(0);
            int rc = st.nextToken().charAt(0);

            if (lc != 46) {
                tree[p - 64][0] = lc - 64;
                tree[lc - 64][2] = p - 64;
            }

            if (rc != 46) {
                tree[p - 64][1] = rc - 64;
                tree[rc - 64][2] = p - 64;
            }
        }

        preorder(1);
        System.out.println();
        inorder(1);
        System.out.println();
        postorder(1);
    }

    private static void preorder(int v) {
        if (v != 0) {
            System.out.print((char) (v + 64));
            preorder(tree[v][0]);
            preorder(tree[v][1]);
        }
    }

    private static void inorder(int v) {
        if (v != 0) {
            inorder(tree[v][0]);
            System.out.print((char) (v + 64));
            inorder(tree[v][1]);
        }
    }

    private static void postorder(int v) {
        if (v != 0) {
            postorder(tree[v][0]);
            postorder(tree[v][1]);
            System.out.print((char) (v + 64));
        }
    }
}
