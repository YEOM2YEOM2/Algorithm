import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static PriorityQueue<Tree> tree1 = new PriorityQueue<>();
    static PriorityQueue<Tree> tree2 = new PriorityQueue<>();
    static int[][] arr; // 현재 각 칸마다의 양분 양
    static int[][] nutrients; // 겨울, 로봇이 각 칸에 양분을 공급할 양
    static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Tree implements Comparable<Tree> {
        int i;
        int j;
        int age;

        public Tree(int i, int j, int age) {
            this.i = i;
            this.j = j;
            this.age = age;
        }


        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        nutrients = new int[N + 1][N + 1];

        // arr[i][j], 5로 값 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], 5);
            arr[i][0] = 0; // 패딩 유지
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().strip());
            for (int j = 1; j <= N; j++) nutrients[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().strip());
            int ci = Integer.parseInt(st.nextToken());
            int cj = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            tree1.offer(new Tree(ci, cj, age));
        }

        for (int i = 0; i < K; i++) solution(i);

        int ans = tree1.size() + tree2.size();
        System.out.println(ans);
    }

    private static void solution(int idx) {
        Queue<Tree> dead = new LinkedList<>();
        Queue<Tree> breeding = new LinkedList<>();
        // 봄, 각 나무 (나이 + 1) 양분 먹음, 먹지 못하면 죽음
        if (idx % 2 == 0) {
            while (!tree1.isEmpty()) {
                Tree tree = tree1.poll();

                if (tree.age <= arr[tree.i][tree.j]) {
                    arr[tree.i][tree.j] -= tree.age;
                    tree2.offer(new Tree(tree.i, tree.j, tree.age + 1));
                    if ((tree.age + 1) % 5 == 0) breeding.offer(new Tree(tree.i, tree.j, tree.age + 1));
                } else {
                    dead.offer(new Tree(tree.i, tree.j, tree.age));
                }
            }
        } else {
            while (!tree2.isEmpty()) {
                Tree tree = tree2.poll();

                if (tree.age <= arr[tree.i][tree.j]) {
                    arr[tree.i][tree.j] -= tree.age;
                    tree1.offer(new Tree(tree.i, tree.j, tree.age + 1));
                    if ((tree.age + 1) % 5 == 0) breeding.offer(new Tree(tree.i, tree.j, tree.age + 1));
                } else {
                    dead.offer(new Tree(tree.i, tree.j, tree.age));
                }
            }
        }
        // 여름, (죽은 나무 / 2 양분) 생성
        while (!dead.isEmpty()) {
            Tree tree = dead.poll();
            arr[tree.i][tree.j] += tree.age / 2;
        }
        // 가을, 나이 5의 배수인 나무 인접 8칸 나이 1인 나무 생성
        while (!breeding.isEmpty()) {
            Tree tree = breeding.poll();

            for (int k = 0; k < 8; k++) {
                int ni = tree.i + di[k];
                int nj = tree.j + dj[k];
                if (1 <= ni && ni <= N && 1 <= nj && nj <= N) {
                    if (idx % 2 == 0) tree2.offer(new Tree(ni, nj, 1));
                    else tree1.offer(new Tree(ni, nj, 1));
                }
            }
        }
        // 겨울, 각 칸 양분 공급
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) arr[i][j] += nutrients[i][j];
        }
    }
}