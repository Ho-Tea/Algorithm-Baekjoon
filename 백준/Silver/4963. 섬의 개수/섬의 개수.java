import java.util.*;
import java.io.*;;


public class Main{
    static boolean [][] visited;
    static int [][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,1}, {-1,-1}, {1,-1}};
    static List<Integer> countList = new ArrayList<>();
    static int N = 0;
    static int M = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0){
                break;
            }
            int [][] map = new int[N][M];
            for(int i = 0; i < N; i++){
                StringTokenizer st1 = new StringTokenizer(bf.readLine());
                for(int j = 0; j < M; j++){
                    map[i][j] = Integer.parseInt(st1.nextToken());
                }
            }

            visited = new boolean[N][M];
            int count = 0;
            for(int i = 0; i< N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 1 && visited[i][j] == false){
                        dfs(i, j, map);
                        count++;
                    }
                }
            }
            countList.add(count);
            }
            for(int count : countList){
                System.out.println(count);
            }
        }

    
    static void dfs(int row, int column, int[][] map){
        visited[row][column] = true;
        for(int[] moved : move){
            if(!(row+moved[0] > N-1 || row+moved[0] < 0 || column+moved[1] > M-1 || column+moved[1] < 0 )){
                if(map[row+moved[0]][column+moved[1]] == 1 && visited[row+moved[0]][column+moved[1]] == false){
                    dfs(row + moved[0], column + moved[1], map);
                }
            }
        }
    }

    }
