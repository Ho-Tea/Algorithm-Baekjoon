import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    ArrayList<Integer> anum = new ArrayList<>();
    Integer[] bnum = new Integer[N];

    StringTokenizer st = new StringTokenizer((br.readLine()));
    while(st.hasMoreTokens())
      anum.add(Integer.parseInt(st.nextToken()));

      int i = 0;
    StringTokenizer std = new StringTokenizer(br.readLine());
    while(std.hasMoreTokens()){
      bnum[i] = Integer.parseInt(std.nextToken());
      i++;
    }
    Object[] aresult = anum.toArray();
    Arrays.sort(aresult);

    
    Arrays.sort(bnum,Comparator.reverseOrder());

    int value = 0;
    for(int k = 0; k < N;k++){
      value += (Integer)aresult[k] * bnum[k]; 
    }

    System.out.println(value);
}}
