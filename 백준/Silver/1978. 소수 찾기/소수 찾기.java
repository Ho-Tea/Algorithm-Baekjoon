import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   String n = br.readLine();
   StringTokenizer st = new StringTokenizer((br.readLine()));

   ArrayList<Integer> num = new ArrayList<>();
  
   int pcs = 0;

   while(st.hasMoreTokens())
      num.add(Integer.parseInt(st.nextToken()));

   for(int number : num){
    int status = 0;
     if(number == 1){
      continue;
     }

     for(int i = 2;i<number;i++){
       if(number%i == 0){
        status++;
        break;
      }
     }
     if(status == 0)
      pcs++;

   }
    
    
  System.out.println(pcs);
  }

  

}