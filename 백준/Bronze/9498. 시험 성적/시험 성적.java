import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int grade = Integer.parseInt(st.nextToken());

    if(grade >= 90 && 100 >= grade){
      System.out.println("A");
    }
    else if( grade >= 80){
      System.out.println("B");
    }
    else if( grade >= 70){
      System.out.println("C");
    }
    else if( grade >= 60){
      System.out.println("D");
    }
    else{
      System.out.println("F");
    }
  }
}