import java.util.*;
import java.io.*;;


public class Main{
    static boolean [][] visited;
    static boolean [][] visitedAbnomal;
    static int [][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static List<Integer> countList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        String [][] map = new String[N][N];
        String [][] abnormalMap = new String[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            String[] rowRGB = st1.nextToken().split("");
            int j = 0;
            for(String rgb : rowRGB){
                map[i][j] = rgb;
                if(rgb.equals("R") || rgb.equals("G")){
                    abnormalMap[i][j] = "R";
                }
                else{
                    abnormalMap[i][j] = "B";
                }
                j++;
            }
            
        }
        int normalCount = 0;
        int abnormalCount = 0;
        visited = new boolean[N][N];
        visitedAbnomal = new boolean[N][N];

        Main test = new Main();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j].equals("R") && visited[i][j] == false){
                    test.dfsNormal(i,j,"R", map);
                    normalCount++;
                }
                if(map[i][j].equals("G") && visited[i][j] == false){
                    test.dfsNormal(i,j,"G", map);
                    normalCount++;
                }
                if(map[i][j].equals("B") && visited[i][j] == false){
                    test.dfsNormal(i,j,"B", map);
                    normalCount++;
                }
                if(abnormalMap[i][j].equals("R") && visitedAbnomal[i][j] == false){
                    test.dfsAbNormal(i,j,"R", abnormalMap);
                    abnormalCount++;
                }
                if(abnormalMap[i][j].equals("B") && visitedAbnomal[i][j] == false){
                    test.dfsAbNormal(i,j,"B", abnormalMap);
                    abnormalCount++;
                }
            }
        } 
        System.out.println(normalCount + " " + abnormalCount);
        
            


        }

        
    void dfsNormal(int row, int column,String rgb, String[][] mapNormal){
        visited[row][column] = true;
        for(int[] moved : move){
            if(!(row+moved[0] > mapNormal[0].length-1 || row+moved[0] < 0 || column+moved[1] > mapNormal[0].length-1 || column+moved[1] < 0 )){
                if(mapNormal[row+moved[0]][column+moved[1]].equals(rgb) && visited[row+moved[0]][column+moved[1]] == false){
                    dfsNormal(row + moved[0], column + moved[1], rgb, mapNormal);
                }
            }
        }
    }
    void dfsAbNormal(int row, int column,String rgb, String[][] mapNormal){
        visitedAbnomal[row][column] = true;
        for(int[] moved : move){
            if(!(row+moved[0] > mapNormal[0].length-1 || row+moved[0] < 0 || column+moved[1] > mapNormal[0].length-1 || column+moved[1] < 0 )){
                if(mapNormal[row+moved[0]][column+moved[1]].equals(rgb) && visitedAbnomal[row+moved[0]][column+moved[1]] == false){
                    dfsAbNormal(row + moved[0], column + moved[1], rgb, mapNormal);
                }
            }
        }
    }

    }
