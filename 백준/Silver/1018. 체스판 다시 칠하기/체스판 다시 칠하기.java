import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st = new StringTokenizer((br.readLine()));
  int N = Integer.parseInt(st.nextToken());
  int M = Integer.parseInt(st.nextToken());

  char[][] board = new char[N][M];
  int max = 0;
  int move = 0;

  for(int i = 0;i < N;i++){
    StringTokenizer std = new StringTokenizer((br.readLine()));
    String row = std.nextToken();
    board[i] = row.toCharArray();
    }

  char[][] case1 = new char[8][8];
  char[][] case2 = new char[8][8];
  
  for(int i = 0; i < 8;i++)
  {
    for(int j = 0; j < 8; j++){
      if((i+j) % 2 == 0)
        case1[i][j] = 'W';
      else
        case1[i][j] = 'B';
    }
  }

  for(int i = 0; i < 8;i++)
  {
    for(int j = 0; j < 8; j++){
      if((i+j) % 2 == 0)
        case2[i][j] = 'B';
      else
        case2[i][j] = 'W';
    }
  }


  while(move+7 < M && move+7 < N){
    int countcase1 = 0;
    int countcase2 = 0;
    int k = 1;

    for(int i = 0;i< 8;i++){
      for(int j = 0;j<8;j++){
          if(board[i+move][j+move] == case1[i][j])
            countcase1++;
          if(board[i+move][j+move] == case2[i][j])
            countcase2++;
    }
  }
    if(countcase1 > max)
      max = countcase1;

    if(countcase2 > max)
      max = countcase2;

    countcase1 = 0;
    countcase2 = 0;

    while(k + 7 + move< M){
      for(int i = 0;i< 8;i++){
        for(int j = 0;j<8;j++){
            if(board[i + move][j + k + move] == case1[i][j])
              countcase1++;
            if(board[i + move][j + k + move] == case2[i][j])
              countcase2++;
      }
    }
    k++;
    if(countcase1 > max)
      max = countcase1;
    if(countcase2 > max)
      max = countcase2;
    countcase1 = 0;
    countcase2 = 0;
  }

    k = 1;
   
    while(k + 7 + move< N){
    for(int i = 0;i<8;i++){
      for(int j = 0;j<8;j++){
          if(board[i + k + move][j + move] == case1[i][j])
            countcase1++;
          if(board[i + k + move][j + move] == case2[i][j])
            countcase2++;
        }
      }
      k++;
      if(countcase1 > max)
        max = countcase1;
      if(countcase2 > max)
        max = countcase2;
      
      countcase1 = 0;
      countcase2 = 0;
    }
    move++;
    }
    System.out.println(64 - max);
    
  }
  }