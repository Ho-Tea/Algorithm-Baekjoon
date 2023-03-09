import java.util.*;
import java.io.*;;


public class Main{
    static boolean [][] visited;
    static int [][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());

        int [][] map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer sc = new StringTokenizer(bf.readLine());
            String[] num = sc.nextToken().split("");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(num[j]);
            }
        }
        List<Integer> total = new ArrayList<>();
        int totalVilige = 0;
        Main test = new Main();
        for(int row = 0; row < n; row++){
            for(int column = 0; column < n; column++){
                if(map[row][column] == 1 && visited[row][column] == false){
                    test.findVilige(row, column, map, visited);
                    totalVilige++;
                    total.add(count+1);
                    count = 0;
                }
            }
        }
        Collections.sort(total);
        total.add(0,totalVilige);
        for(int number : total){
            System.out.println(number);
        }
        
    }

    
    void findVilige(int row, int column, int[][] map,boolean[][] visited){
        visited[row][column] = true;
        for(int [] moved : move){
            if(!(row + moved[0] > map.length-1 || row + moved[0] < 0 || column + moved[1] > map.length-1 || column + moved[1] < 0 )){
                if(map[row+moved[0]][column+moved[1]] == 1 && visited[row+moved[0]][column+moved[1]] == false){
                    findVilige(row+moved[0], column+moved[1], map, visited);
                    count++;
                }
            }
        }
    }

}