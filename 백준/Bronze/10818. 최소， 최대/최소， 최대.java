import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int A = scan.nextInt();
    int[] num = new int[A];

    for(int i = 0;i<A;i++){
      int b = scan.nextInt();
      num[i] = b;
    }
    Arrays.sort(num);
    
    System.out.print(num[0]);
    System.out.print(' ');
    System.out.print(num[A-1]);
    
  }
}