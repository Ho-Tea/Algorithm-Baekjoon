import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st = new StringTokenizer((br.readLine()));
  int money = Integer.parseInt(st.nextToken());
  int status = 0;
  int ewon = 0;
  int owon = money / 5;
  while(money != 0)
  {
    if((money-(5*owon))%2 == 0){
      ewon = (money-(5*owon))/2;
      money -= 5*owon;
      money -= 2*ewon;
    }
    else if(owon == 0 && money%2 != 0){
      System.out.println("-1");
      status = 1;
      break;    
    }
    else{
      owon--;
    }
    
  }
  if(status != 1)
    System.out.println(owon+ewon);
  }}