import java.io.*;
import java.util.*;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int first = 0;
    int second = 0;
  
    for(int i = 0; i < N; i++){
      StringTokenizer sd = new StringTokenizer(br.readLine());
      first = Integer.parseInt(sd.nextToken());
      second = Integer.parseInt(sd.nextToken());

      System.out.println(first+second);
    }
  }
}
