import java.util.*;
import java.io.*;;

public class Main {
    static boolean[][] visited;
    static List<Integer> countList = new ArrayList<>();
    static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][] map;
    static Queue<int[]> originQ = new LinkedList<>();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        makeWall(0);
        System.out.println(Collections.max(countList));
    }

    static void makeWall(int wallcount) {
        int count = wallcount;
        if (count == 3) {
            bfs();
            return;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        makeWall(count + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }

    }

    // static void dfs(int row, int column, int[][] map){
    // count++;
    // visited[row][column] = true;
    // for(int[] moved : move){
    // if(!(row+moved[0] > N-1 || row+moved[0] < 0 || column+moved[1] > M-1 ||
    // column+moved[1] < 0 )){
    // if(map[row+moved[0]][column+moved[1]] == 1 &&
    // visited[row+moved[0]][column+moved[1]] == false){
    // dfs(row + moved[0], column + moved[1], map);
    // }
    // }
    // }
    // }

    static void bfs() {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        int[][] cpyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cpyMap[i][j] = map[i][j];
                if (map[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int[] moved : move) {
                if (!(temp[0] + moved[0] > N - 1 || temp[0] + moved[0] < 0 || temp[1] + moved[1] > M - 1
                        || temp[1] + moved[1] < 0)) {
                    if (cpyMap[temp[0] + moved[0]][temp[1] + moved[1]] == 0) {
                        q.offer(new int[] { temp[0] + moved[0], temp[1] + moved[1] });
                        cpyMap[temp[0] + moved[0]][temp[1] + moved[1]] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cpyMap[i][j] == 0) {
                    count++;
                }
            }
        }
        countList.add(count);

    }

}
