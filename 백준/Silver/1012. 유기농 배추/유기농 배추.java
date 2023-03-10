import java.util.*;
import java.io.*;;


public class Main{
    static boolean [][] visited;
    static int [][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static List<Integer> countList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for(int i = 0; i < testCase; i++){
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(st1.nextToken());
            int N = Integer.parseInt(st1.nextToken());
            int K = Integer.parseInt(st1.nextToken());

            int [][] map = new int[N][M];
            visited = new boolean[N][M];
            
            Main test = new Main();

            int total = 0;
            for(int j = 0; j < K; j++){
                StringTokenizer sc = new StringTokenizer(bf.readLine());
                int column = Integer.parseInt(sc.nextToken());
                int row = Integer.parseInt(sc.nextToken());
                map[row][column] = 1;

            }
            for(int row = 0; row < N; row++){
                for(int column = 0; column < M; column++){
                    if(map[row][column] == 1 && visited[row][column] == false){
                        test.findVilige(row, column, map, visited, N, M);
                        total++;
                    }
                }
            }
            countList.add(total);
        }
        
        
        for(int number : countList){
            System.out.println(number);
        }
        
    }


    void findVilige(int row, int column, int[][] map,boolean[][] visited, int N, int M){
        visited[row][column] = true;
        for(int [] moved : move){
            if(!(row + moved[0] > N-1 || row + moved[0] < 0 || column + moved[1] > M-1 || column + moved[1] < 0 )){
                if(map[row+moved[0]][column+moved[1]] == 1 && visited[row+moved[0]][column+moved[1]] == false){
                    findVilige(row+moved[0], column+moved[1], map, visited, N , M);
                }
            }
        }
    }

}