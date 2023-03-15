import java.util.*;
import java.io.*;;


public class Main{
    static boolean [][] visited;
    static int [][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int [][] map;
    static int [][] difs;
    static List<Integer> countList = new ArrayList<>();
    static int count;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        difs = new int[N][M];
        for(int i = 0; i < N; i++){
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            String[] row = st1.nextToken().split("");
            int j = 0;
            for(String node : row){
                map[i][j] = Integer.parseInt(node);
                j++;
            }
        }

        visited = new boolean[N][M];
        bfs(0,0);
        
    }
           
    static void dfs(int row, int column, int[][] map){
        count++;
        visited[row][column] = true;
        for(int[] moved : move){
            if(!(row+moved[0] > N-1 || row+moved[0] < 0 || column+moved[1] > M-1 || column+moved[1] < 0 )){
                if(map[row+moved[0]][column+moved[1]] == 1 && visited[row+moved[0]][column+moved[1]] == false){
                    dfs(row + moved[0], column + moved[1], map);
                }
            }
        }
    }

    static void bfs(int row, int column){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, column});
        visited[row][column] = true;
        difs[row][column] = 1;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int[] moved : move){
                if(!(temp[0]+moved[0] > N-1 || temp[0] + moved[0] < 0 || temp[1]+moved[1] > M-1|| temp[1] + moved[1] <0) ){
                    if(map[temp[0]+moved[0]][temp[1] + moved[1]] == 1 && visited[temp[0]+moved[0]][temp[1] + moved[1]] == false){
                        visited[temp[0]+moved[0]][temp[1] + moved[1]] = true;
                        q.offer(new int[] {temp[0]+moved[0], temp[1]+moved[1]});
                        difs[temp[0]+moved[0]][temp[1] + moved[1]] = difs[temp[0]][temp[1]] + 1;
                        if(temp[0] + moved[0] == N-1 && temp[1] + moved[1] == M-1 ){
                            System.out.println(difs[temp[0]+moved[0]][temp[1] + moved[1]]);
                            return;
                        }
                    }
                    
                }
            }
        }


    }

    }
