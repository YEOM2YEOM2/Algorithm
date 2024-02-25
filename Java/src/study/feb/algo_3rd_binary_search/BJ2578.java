package study.feb.algo_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2578 {

    static int[][] user = new int[5][5];
    static int[][] arr = new int[5][5];

    static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                user[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bingo());
    }

    private static Node find(int temp) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (user[i][j] == temp) {
                    Node node = new Node(i, j);
                    return node;
                }
            }
        }
        return null;
    }

    private static int bingo() {
        int cnt = 0;
        int[] row = new int[5];
        int[] col = new int[5];
        int[] cross = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cnt++;
                Node node = find(arr[i][j]);

                row[node.i]++;
                col[node.j]++;
                if (node.i == node.j) {
                    cross[0]++;
                }
                if (node.i + node.j == 4) {
                    cross[1]++;
                }

                int temp = 0;
                for (int k = 0; k < 5; k++) {
                    if (row[k] == 5) temp++;
                    if (col[k] == 5) temp++;
                }
                if (cross[0] == 5) temp++;
                if (cross[1] == 5) temp++;

                if (temp >= 3) {
                    return cnt;
                }
            }
        }
        return cnt;
    }

}
