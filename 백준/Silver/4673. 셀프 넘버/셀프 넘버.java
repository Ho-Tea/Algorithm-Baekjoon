import java.util.ArrayList;

public class Main {
  public static void main(String[] args){
    boolean[] input = new boolean[10001];

    for(int i = 0;i<10000;i++){
        d(i+1,input);
    }

    for(int i = 0; i < 10000;i++){
      if(input[i] == false)
        System.out.println(i+1);}
  }
  static int d(int i,boolean input[]){
    int num = i + i/1000 + i/100-((i/1000)*10) + i/10-((i/100)*10) + i-((i/10)*10);
    if(num > 10000)
      return 0;
    input[num-1] = true;
    return d(num,input);
  }
}