import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Node> chickens = new ArrayList<>();
    static ArrayList<Node> houses = new ArrayList<>();

    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static int[] order;

    public static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        order = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().strip());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) houses.add(new Node(i, j));
                else if (num == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        nums = new int[chickens.size()];
        for (int i = 0; i < chickens.size(); i++) nums[i] = i;

        comb(0, 0);
        System.out.println(min);
    }

    public static void comb(int s, int k) {
        if (k == M) {
            solution();
            return;
        }

        for (int i = s; i < chickens.size(); i++) {
            order[k] = nums[i];
            comb(i + 1, k + 1);
        }
    }

    public static void solution() {
        int sum = 0;
        for (int i = 0; i < houses.size(); i++) { // 집
            Node house = houses.get(i);
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {  // 치킨집 M개 선정
                Node chicken = chickens.get(order[j]);
                int distance = Math.abs(house.i - chicken.i) + Math.abs(house.j - chicken.j);
                temp = Math.min(temp, distance);
            }
            sum += temp;
        }

        min = Math.min(sum, min);
    }
}