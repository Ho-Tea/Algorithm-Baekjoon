import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st = new StringTokenizer((br.readLine()));
  int s = Integer.parseInt(st.nextToken());
  
  for(int i = 0 ; i < s; i++){
    StringTokenizer sd = new StringTokenizer((br.readLine()));
    int a = Integer.parseInt(sd.nextToken());
    int b = Integer.parseInt(sd.nextToken());
    System.out.println("Case #"+ (i+1) +": " + (a+b));
  }
}
}