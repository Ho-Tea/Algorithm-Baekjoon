import java.util.*;
import java.io.*;;


public class Main{
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int computerNum = Integer.parseInt(st.nextToken());
        StringTokenizer sd = new StringTokenizer(bf.readLine());
        int worm = Integer.parseInt(sd.nextToken());

        int [][] map = new int[computerNum+1][computerNum+1];
        
        for(int i = 0; i < worm; i++){
            StringTokenizer sc = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(sc.nextToken());
            int second = Integer.parseInt(sc.nextToken());
            map[first][second] = 1;
        }

        boolean [] visited = new boolean[computerNum + 1];

        Main test = new Main();
        
        test.dfs(1, map, visited);
        System.out.println(count);

    }
    void dfs(int node, int[][] map, boolean[] visited){
        visited[node] = true;
        for(int i = 1; i < visited.length; i++){
            if((map[node][i] == 1 || map[i][node] == 1) && visited[i] == false ){
                dfs(i, map, visited);
                count++;
            } 
        }
    }
}