import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < line.length; i++){
            int[] li = line[i];
            map.put(i, li);
        }
        List<long[]> candidate = new ArrayList<>();
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for(int i = 0; i < map.size(); i++){
            int[] origin = map.get(i);
            for(int j = i; j <map.size(); j++){
                if(i == j){
                    continue;
                }
                int[] target = map.get(j);
                long a = origin[0];
                long b = origin[1];
                long e = origin[2];
                long c = target[0];
                long d = target[1];
                long f = target[2];
                // 공식 대입
                if((a*d)-(b*c) == 0){
                    continue;
                }
                if(((b*f) - (e*d))%((a*d)-(b*c)) != 0 || ((e*c) - (a*f))%((a*d)-(b*c)) != 0){
                    continue;
                }
                
                long x = ((b*f) - (e*d))/((a*d)-(b*c));
                long y = ((e*c) - (a*f))/((a*d)-(b*c));
            
                if(x > maxX){
                    maxX = x;
                }if(x < minX){
                    minX = x;
                }
                if(y > maxY){
                    maxY = y;
                }if(y < minY){
                    minY = y;
                }
                
                candidate.add(new long[]{x,y});
            }
        }
        if(candidate.isEmpty()) {
            return new String[]{ "." };
        }
        
        long yLength  = Math.abs(maxY - minY) + 1;
        long xLength = Math.abs(maxX - minX) + 1;
        
        Set<String> star = new HashSet<>();
        for(long[] result : candidate){
            long col = result[0] - minX;
            long row = maxY - result[1];
            star.add(col + "," + row);
        }
        

        
        String[] answer = new String[(int)yLength];
        
        for(int i = 0; i < yLength; i++){
            StringBuilder re = new StringBuilder();
            for(int j = 0; j < xLength; j++){
                if(star.contains(j + "," + i)){
                    re.append("*");
                    continue;
                }
                re.append(".");
            }
            answer[i] = re.toString();
        }
        
        
        return answer;
    }
}