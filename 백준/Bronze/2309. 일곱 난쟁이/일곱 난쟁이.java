import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
   for(int i = 0; i < 9; i++){
      nums.add(Integer.parseInt(br.readLine()));
   }
   int sum = 0;
   for(int i = 0;i < 9; i++){
     sum += nums.get(i);
   }
  int id = 0;
  int jd = 0;
  sum = sum - 100;
   for(int i = 0; i < 8;i++){
     for(int j = i + 1; j< 9;j++){
         int sumd = nums.get(i)+nums.get(j);
          if(sum == sumd){
            id = nums.get(i);
            jd = nums.get(j);
          }
       }
       
     }
   
   nums.remove(Integer.valueOf(id));
   nums.remove(Integer.valueOf(jd));
   
   
   
   Collections.sort(nums);
   for(int i = 0; i < 7;i++){
   System.out.println(nums.get(i));
   }
}
  }