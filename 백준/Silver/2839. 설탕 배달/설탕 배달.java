import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    
    int five = num/5;
    int three = num/3;
    
    int bag = 0;
    
    for(int i = 0;i <= three;i++){
      for(int j =0;j <= five;j++){
        if(num == (i*3 + j*5)){
          bag = i + j;
          break;
        }}
        if(bag > 0)
          break;
      }

      if(bag == 0)
        System.out.println(-1);
      else
        System.out.println(bag);

  }}