import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, K;
    static ArrayList<Node> stars = new ArrayList<>();

    static public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stars.add(new Node(x, y));
        }

        int cnt = 0;
        for (int i = 0; i < K; i++) {
            Node star1 = stars.get(i);
            for (int j = 0; j < K; j++) {
                Node star2 = stars.get(j);
                cnt = Math.max(countStar(star1.x, star2.y), cnt);
            }
        }
        System.out.println(K - cnt);
    }

    private static int countStar(int x, int y) {
        int temp = 0;
        for (int k = 0; k < K; k++) {
            Node star = stars.get(k);
            // star는 x, y가 N, M을 넘지 않음. → x + L이 N보다 커지는 경우 고려할 필요 x
            if (x <= star.x && star.x <= x + L && y <= star.y && star.y <= y + L) temp++;
        }
        return temp;
    }
}