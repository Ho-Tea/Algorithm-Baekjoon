import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int A = scan.nextInt();
    int B = scan.nextInt();
    
    A = A/100 + (A%100-A%10)+((A%10)*100);
    B = B/100 + (B%100-B%10)+((B%10)*100);
      
    if(A > B)
        System.out.println(A);
    else if(B > A)
        System.out.println(B);
    
  }
}