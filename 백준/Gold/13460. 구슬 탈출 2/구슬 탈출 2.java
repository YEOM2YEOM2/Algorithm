import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] arr;

    static class Node {
        Bead red;
        Bead blue;
        int cnt;

        public Node(Bead red, Bead blue, int cnt) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }
    }

    static class Bead {
        int i;
        int j;

        public Bead() {

        }

        public Bead(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().strip());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine().strip();
            for (int j = 0; j < M; j++) arr[i][j] = row.charAt(j);
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        // 구슬 & 구멍 위치 찾기
        Bead red = new Bead(); Bead blue = new Bead();
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (arr[i][j] != '#') {
                    if (arr[i][j] == 'R') {
                        red = new Bead(i, j);
                        arr[i][j] = '.';
                    } else if (arr[i][j] == 'B') {
                        blue = new Bead(i, j);
                        arr[i][j] = '.';
                    }
                }
            }
        }
        // bfs 큐 세팅
        Queue<Node> q = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>(); // 빨간 구슬 좌표 : key, 파란 구슬 좌표 : value
        q.offer(new Node(red, blue, 0));
        // 기울이기 10회 이하에서 빨간 구슬만 탈출 x
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.cnt > 10) return -1;
            if (node.blue.i == -1) continue;
            if (node.red.i == -1) return node.cnt;

            String key = "" + node.red.i + node.red.j + node.blue.i + node.blue.j;
            if (visited.containsKey(key)) continue;
            visited.put(key, true);

            // 위로 기울이기
            for (int i = node.red.i - 1; i > -1; i--) {
                if (arr[i][node.red.j] == 'O') {
                    red = new Bead(-1, -1);
                    break;
                } else if (arr[i][node.red.j] == '#') {
                    red = new Bead(i + 1, node.red.j);
                    break;
                }
            }

            for (int i = node.blue.i - 1; i > -1; i--) {
                if (arr[i][node.blue.j] == 'O') {
                    blue = new Bead(-1, -1);
                    break;
                } else if (arr[i][node.blue.j] == '#') {
                    blue = new Bead(i + 1, node.blue.j);
                    break;
                }
            }

            // 파란 공 & 빨간 공 열 위치 같음 + " 행 위치 같음.
            if (red.i != -1 && red.i == blue.i && red.j == blue.j) {
                if (node.red.i < node.blue.i) blue.i = red.i + 1;
                else if (node.red.i > node.blue.i) red.i = blue.i + 1;
            }
            q.offer(new Node(red, blue, node.cnt + 1));
            // 아래로 기울이기
            for (int i = node.red.i + 1; i < N; i++) {
                if (arr[i][node.red.j] == 'O') {
                    red = new Bead(-1, -1);
                    break;
                } else if (arr[i][node.red.j] == '#') {
                    red = new Bead(i - 1, node.red.j);
                    break;
                }
            }

            for (int i = node.blue.i + 1; i < N; i++) {
                if (arr[i][node.blue.j] == 'O') {
                    blue = new Bead(-1, -1);
                    break;
                } else if (arr[i][node.blue.j] == '#') {
                    blue = new Bead(i - 1, node.blue.j);
                    break;
                }
            }

            if (red.i != -1 && red.i == blue.i && red.j == blue.j) {
                if (node.red.i < node.blue.i) red.i = blue.i - 1;
                else if (node.red.i > node.blue.i) blue.i = red.i - 1;
            }
            q.offer(new Node(red, blue, node.cnt + 1));
            // 오른쪽 기울이기
            for (int j = node.red.j + 1; j < M; j++) {
                if (arr[node.red.i][j] == 'O') {
                    red = new Bead(-1, -1);
                    break;
                } else if (arr[node.red.i][j] == '#') {
                    red = new Bead(node.red.i, j - 1);
                    break;
                }
            }

            for (int j = node.blue.j + 1; j < M; j++) {
                if (arr[node.blue.i][j] == 'O') {
                    blue = new Bead(-1, -1);
                    break;
                } else if (arr[node.blue.i][j] == '#') {
                    blue = new Bead(node.blue.i, j - 1);
                    break;
                }
            }

            if (red.i != -1 && red.i == blue.i && red.j == blue.j) {
                if (node.red.j < node.blue.j) red.j = blue.j - 1;
                else if (node.red.j > node.blue.j) blue.j = red.j - 1;
            }
            q.offer(new Node(red, blue, node.cnt + 1));
            // 왼쪽 기울이기
            for (int j = node.red.j - 1; j > -1; j--) {
                if (arr[node.red.i][j] == 'O') {
                    red = new Bead(-1, -1);
                    break;
                } else if (arr[node.red.i][j] == '#') {
                    red = new Bead(node.red.i, j + 1);
                    break;
                }
            }

            for (int j = node.blue.j - 1; j > -1; j--) {
                if (arr[node.blue.i][j] == 'O') {
                    blue = new Bead(-1, -1);
                    break;
                } else if (arr[node.blue.i][j] == '#') {
                    blue = new Bead(node.blue.i, j + 1);
                    break;
                }
            }

            if (red.i != -1 && red.i == blue.i && red.j == blue.j) {
                if (node.red.j < node.blue.j) blue.j = red.j + 1;
                else if (node.red.j > node.blue.j) red.j = blue.j + 1;
            }
            q.offer(new Node(red, blue, node.cnt + 1));
        }
        return -1;
    }
}