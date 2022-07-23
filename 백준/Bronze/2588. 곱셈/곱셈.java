import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int A = scan.nextInt();
    int B = scan.nextInt();
    
    
    System.out.println(A * (B % 10));
    System.out.println(A * ((B%100)-B%10)/10);
    System.out.println((A * (B-(B%100))/100));
    System.out.println(A * B);
    
  }
}