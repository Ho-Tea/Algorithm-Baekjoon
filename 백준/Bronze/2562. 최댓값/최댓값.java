import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
   ArrayList<Integer> nums = new ArrayList<>();
   for(int i = 0;i <9;i++){
     int num = Integer.parseInt(br.readLine());
     nums.add(num);
   }

   int max = 0;
   int maxnum = 999;
   for(int i = 0;i <9;i++){
    if(nums.get(i) > max)
      max = nums.get(i);
      maxnum = nums.indexOf(max);
  }
   
   
   System.out.println(max);
   System.out.println(maxnum+1);
  
  }
    
  }
  

  