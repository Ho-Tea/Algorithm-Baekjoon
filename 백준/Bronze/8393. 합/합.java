import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int A = scan.nextInt();
    int sum = 0;
    while(A > 0){
      sum += A;
      A--;
    }
    System.out.print(sum);
  }
}