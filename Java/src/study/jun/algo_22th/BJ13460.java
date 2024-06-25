package study.jun.algo_22th;

import java.io.*;
import java.util.*;

public class BJ13460 {
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
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
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
        q.offer(new Node(red, blue, 0));
        // 기울이기 10회 이하에서 빨간 구슬만 탈출 x
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.cnt > 10) return -1;
            if (node.blue.i == -1) continue;
            if (node.red.i == -1 && node.blue.i != -1) return node.cnt;


            boolean flag = false;
            if (node.red.i < node.blue.i) {
                // 위로 기울이기
                for (int i = node.red.i - 1; i > -1; i--) {
                    if (arr[i][node.red.j] == 'O') {
                        red = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[i][node.red.j] == '#') {
                        red = new Bead(i + 1, node.red.j);
                        flag = true;
                        break;
                    }
                }

                if (!flag) red = new Bead(0, node.red.j);

                flag = false;
                for (int i = node.blue.i - 1; i > -1; i--) {
                    if (arr[i][node.blue.j] == 'O') {
                        blue = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[i][node.blue.j] == '#') {
                        blue = new Bead(i + 1, node.blue.j);
                        flag = true;
                        break;
                    }
                }

                if (!flag) blue = new Bead(0, node.blue.j);
                // 파란 공 & 빨간 공 열 위치 같음 + " 행 위치 같음.
                if (blue.j == red.j && blue.i == red.i) blue.i = red.i + 1;
                q.offer(new Node(red, blue, node.cnt + 1));
                // 아래로 기울이기
                flag = false;
                for (int i = node.blue.i + 1; i < N; i++) {
                    if (arr[i][node.blue.j] == 'O') {
                        blue = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[i][node.blue.j] == '#') {
                        blue = new Bead(i - 1, node.blue.j);
                        flag = true;
                        break;
                    }
                }

                if (!flag) blue = new Bead(N - 1, node.blue.j);

                flag = false;
                for (int i = node.red.i; i < N; i++) {
                    if (arr[i][node.red.j] == 'O') {
                        red = new Bead(-1, -1);
                        flag = true;
                    } else if (arr[i][node.red.j] == '#') {
                        red = new Bead(i - 1, node.red.j);
                        flag = true;
                        break;
                    }
                }

                if (!flag) red = new Bead(N - 1, node.red.j);
                if (red.j == blue.j && red.i == blue.i) red.i = blue.i - 1;
                q.offer(new Node(red, blue, node.cnt + 1));
            } else {
                // 위로 기울이기
                for (int i = node.blue.i - 1; i > -1; i--) {
                    if (arr[i][node.blue.j] == 'O') {
                        blue = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[i][node.blue.j] == '#') {
                        blue = new Bead(i + 1, node.blue.j);
                        flag = true;
                        break;
                    }
                }

                if (!flag) blue = new Bead(0, node.blue.j);

                flag = false;
                for (int i = node.red.i - 1; i > -1; i--) {
                    if (arr[i][node.red.j] == 'O') {
                        red = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[i][node.red.j] == '#') {
                        red = new Bead(i + 1, node.red.j);
                        flag = true;
                        break;
                    }
                }

                if (!flag) red = new Bead(0, node.red.j);
                if (blue.j == red.j && blue.i == red.i) red.i = blue.i + 1;
                q.offer(new Node(red, blue, node.cnt + 1));
                // 아래로 기울이기
                flag = false;
                for (int i = node.red.i + 1; i < N; i++) {
                    if (arr[i][node.red.j] == 'O') {
                        red = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[i][node.red.j] == '#') {
                        red = new Bead(i - 1, node.red.j);
                        flag = true;
                        break;
                    }
                }

                if (!flag) red = new Bead(N - 1, node.red.j);

                flag = false;
                for (int i = node.blue.i; i < N; i++) {
                    if (arr[i][node.blue.j] == 'O') {
                        blue = new Bead(-1, -1);
                        flag = true;
                    } else if (arr[i][node.blue.j] == '#') {
                        blue = new Bead(i - 1, node.blue.j);
                        flag = true;
                        break;
                    }
                }

                if (!flag) blue = new Bead(N - 1, node.blue.j);
                if (red.j == blue.j && red.i == blue.i) blue.i = red.i - 1;
                q.offer(new Node(red, blue, node.cnt + 1));
            }
            if (node.red.j > node.blue.j) {
                // 오른쪽 기울이기
                flag = false;
                for (int j = node.red.j + 1; j < M; j++) {
                    if (arr[node.red.i][j] == 'O') {
                        red = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[node.red.i][j] == '#') {
                        red = new Bead(node.red.i, j - 1);
                        flag = true;
                        break;
                    }
                }

                if (!flag) red = new Bead(node.red.i, M - 1);

                flag = false;
                for (int j = node.blue.j + 1; j < M; j++) {
                    if (arr[node.blue.i][j] == 'O') {
                        blue = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[node.blue.i][j] == '#') {
                        blue = new Bead(node.blue.i, j - 1);
                        flag = true;
                        break;
                    }
                }

                if (!flag) blue = new Bead(node.blue.i, M - 1);
                if (red.i == blue.i && red.j == blue.j) blue.j = red.j - 1;
                q.offer(new Node(red, blue, node.cnt + 1));
                // 왼쪽 기울이기
                flag = false;
                for (int j = node.blue.j - 1; j > -1; j--) {
                    if (arr[node.blue.i][j] == 'O') {
                        blue = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[node.blue.i][j] == '#') {
                        blue = new Bead(node.blue.i, j + 1);
                        flag = true;
                        break;
                    }
                }

                if (!flag) blue = new Bead(node.blue.i, 0);

                flag = false;
                for (int j = node.red.j - 1; j > -1; j--) {
                    if (arr[node.red.i][j] == 'O') {
                        red = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[node.red.i][j] == '#') {
                        red = new Bead(node.red.i, j + 1);
                        flag = true;
                        break;
                    }
                }

                if (!flag) red = new Bead(node.red.i, 0);
                if (red.i == blue.i && red.j == blue.j) red.j = blue.j + 1;
                q.offer(new Node(red, blue, node.cnt + 1));
            } else {
                // 오른쪽 기울이기
                flag = false;
                for (int j = node.blue.j + 1; j < M; j++) {
                    if (arr[node.blue.i][j] == 'O') {
                        blue = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[node.blue.i][j] == '#') {
                        blue = new Bead(node.blue.i, j - 1);
                        flag = true;
                        break;
                    }
                }

                if (!flag) blue = new Bead(node.blue.i, M - 1);

                flag = false;
                for (int j = node.red.j + 1; j < M; j++) {
                    if (arr[node.red.i][j] == 'O') {
                        red = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[node.red.i][j] == '#') {
                        red = new Bead(node.red.i, j - 1);
                        flag = true;
                        break;
                    }
                }

                if (!flag) red = new Bead(node.red.i, M - 1);
                if (red.i == blue.i && red.j == blue.j) red.j = blue.j - 1;
                q.offer(new Node(red, blue, node.cnt + 1));
                // 왼쪽 기울이기
                flag = false;
                for (int j = node.red.j - 1; j > -1; j--) {
                    if (arr[node.red.i][j] == 'O') {
                        red = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[node.red.i][j] == '#') {
                        red = new Bead(node.red.i, j + 1);
                        flag = true;
                        break;
                    }
                }

                if (!flag) red = new Bead(node.red.i, 0);

                flag = false;
                for (int j = node.blue.j - 1; j > -1; j--) {
                    if (arr[node.blue.i][j] == 'O') {
                        blue = new Bead(-1, -1);
                        flag = true;
                        break;
                    } else if (arr[node.blue.i][j] == '#') {
                        blue = new Bead(node.blue.i, j + 1);
                        flag = true;
                        break;
                    }
                }

                if (!flag) blue = new Bead(node.blue.i, 0);
                if (red.i == blue.i && red.j == blue.j) blue.j = red.j + 1;
                q.offer(new Node(red, blue, node.cnt + 1));
            }
        }
        return -1;
    }
}