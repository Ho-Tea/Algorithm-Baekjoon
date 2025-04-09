import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long)times[times.length-1] * (long)n;
        long result = 0;
        while(left < right){
            long mid = (left+right) / 2;
            long person = 0;
            for(int i = 0; i < times.length; i++){
                person += mid/times[i];
            }
            if(person < n){
                left = mid + 1;
            }else{
                right = mid;
                result = mid;
            }
        }
        return result;
    }
    
}