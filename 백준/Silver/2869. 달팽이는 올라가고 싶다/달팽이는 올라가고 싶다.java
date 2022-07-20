import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer((br.readLine()));
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    int t = A-B;
    int point = V - A;
    int day = point / t;
    int pointday = point % t;
    
    if(pointday == 0)
      day = day + 1;
    else
      day = day + 2;
    System.out.println(day);
    
  }}