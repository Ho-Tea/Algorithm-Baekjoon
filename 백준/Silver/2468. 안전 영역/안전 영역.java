import java.util.*;
import java.io.*;;

public class Main {
    static boolean[][] visited;
    static List<int[]> countList = new ArrayList<>();
    static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][] map;
    static int[][] cpymap;
    static Queue<int[]> originQ = new LinkedList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        for (int k = 0; k <= max; k++) {
            cpymap = new int[N][N];
            boolean[][] visit = new boolean[N][N];
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    cpymap[a][b] = map[a][b];
                    if (cpymap[a][b] < k) {
                        cpymap[a][b] = 0;
                    } else {
                        cpymap[a][b] = 1;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (cpymap[i][j] == 1 && visit[i][j] == false) {
                        dfs(i, j, visit, cpymap);
                        count++;
                    }
                }
            }
            countList.add(new int[] { k, count });
        }

        int maximum = 0;
        for (int[] node : countList) {
            if (node[1] > maximum) {
                maximum = node[1];
            }
        }
        for (int[] node : countList) {
            if (node[1] == maximum) {
                System.out.println(node[1]);
                break;
            }
        }
    }

    static void dfs(int row, int column, boolean[][] visit, int[][] d) {
        visit[row][column] = true;
        for (int[] moved : move) {
            if (!(row + moved[0] > N - 1 || row + moved[0] < 0 || column + moved[1] > N - 1
                    || column + moved[1] < 0)) {
                if (d[row + moved[0]][column + moved[1]] == 1
                        && visit[row + moved[0]][column + moved[1]] == false) {
                    dfs(row + moved[0], column + moved[1], visit, d);
                }
            }
        }

    }

}
