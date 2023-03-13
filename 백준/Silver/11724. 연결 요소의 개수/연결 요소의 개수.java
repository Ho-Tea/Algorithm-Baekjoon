import java.util.*;
import java.io.*;;


public class Main{
    static boolean [] visited;
    static int [][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static List<Integer> countList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] map = new int[N][N];
        for(int i = 0; i < M; i++){
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int node1 = Integer.parseInt(st1.nextToken());
            int node2 = Integer.parseInt(st1.nextToken());

            map[node1-1][node2-1] = 1;
        }

        visited = new boolean[N];
        int count = 0;
        Main test = new Main();
        for(int i = 0; i < N; i++){ 
            if(visited[i] == false){
                test.dfs(i, map);
                count++;
            }
        }
        System.out.println(count);
    

        }

        


    void dfs(int node, int[][] map){
        visited[node] = true;
        for(int j = 0; j < visited.length; j++){
            if((map[node][j] == 1 || map[j][node] == 1) && visited[j] == false){
                dfs(j, map);
            }
        }
    }
}
