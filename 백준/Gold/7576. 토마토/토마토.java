import java.util.*;
import java.io.*;;


public class Main{
    static boolean [][] visited;
    static int [][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int [][] map;
    static int [][] difs;
    static Queue<int[]> q = new LinkedList<>();
    static int count;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        difs = new int[N][M];
        for(int i = 0; i < N; i++){
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st1.nextToken());
                if(map[i][j] == -1){
                    visited[i][j] = true;
                }
                if(map[i][j] == 1){
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                    difs[i][j] = 1;
                }
            }
        }
    int total = 0;
   
    bfs();   

    
    int temp = 0;
    for(int i = 0; i < N; i++){
        for(int j = 0; j< M; j++){
            if(difs[i][j] >= temp){
                total = difs[i][j] - 1;
                temp = difs[i][j];
            }
        }
    }   
    for(int i = 0; i < N; i++){
        for(int j = 0; j< M; j++){
            if(visited[i][j] == false){
                total = -1;
            }
        }
    }   
    
    System.out.println(total);
    }
           
    // static void dfs(int row, int column, int[][] map){
    //     count++;
    //     visited[row][column] = true;
    //     for(int[] moved : move){
    //         if(!(row+moved[0] > N-1 || row+moved[0] < 0 || column+moved[1] > M-1 || column+moved[1] < 0 )){
    //             if(map[row+moved[0]][column+moved[1]] == 1 && visited[row+moved[0]][column+moved[1]] == false){
    //                 dfs(row + moved[0], column + moved[1], map);
    //             }
    //         }
    //     }
    // }

    static void bfs(){
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int[] moved : move){
                if(!(temp[0]+moved[0] > N-1 || temp[0] + moved[0] < 0 || temp[1]+moved[1] > M-1|| temp[1] + moved[1] <0) ){
                    if(map[temp[0]+moved[0]][temp[1] + moved[1]] == 0 && visited[temp[0]+moved[0]][temp[1] + moved[1]] == false){
                        visited[temp[0]+moved[0]][temp[1] + moved[1]] = true;
                        q.offer(new int[] {temp[0]+moved[0], temp[1]+moved[1]});
                        difs[temp[0]+moved[0]][temp[1] + moved[1]] = difs[temp[0]][temp[1]] + 1;
                    }
                    
                }
            }
        }
        


    }

    }
