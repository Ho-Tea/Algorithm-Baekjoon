import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st = new StringTokenizer((br.readLine()));

   int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    


    boolean[] array = new boolean[end+1];
    array[0] = true; //1을 분류하고 시작

    for(int i = end;i  >= start;i--){
      int root = (int)Math.sqrt(i);
      for(int j = 2;j <= root;j++){
        if(i % j == 0){
          array[i-1] = true;
          break;
        }
      }
    }
      
      
    
    for(int i = start ; i <= end;i++){
      if(array[i-1] == false)
        System.out.println(i); 
    }
    
  
}}