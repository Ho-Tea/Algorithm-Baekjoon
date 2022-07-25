import java.util.*;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int A = scan.nextInt();
    int B = scan.nextInt();
    int[] arr = new int[A];
    ArrayList sum = new ArrayList<Integer>();
    for(int i =0;i<A;i++){
      arr[i] = scan.nextInt();
      if(arr[i] < B){
        sum.add(arr[i]);
      }
    }
    for(int i = 0;i<sum.size();i++){
      System.out.print(sum.get(i));
      System.out.print(' ');
    }
    
}}