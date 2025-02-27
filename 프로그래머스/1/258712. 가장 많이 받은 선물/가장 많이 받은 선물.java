import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int[][] status = new int[friends.length][friends.length];
        int[] giftstatus = new int[friends.length];
        
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < friends.length; i++){
            map.put(friends[i], i);
        }
        
        Map<String, Integer> giftmap = new HashMap<>();
        for(int i = 0; i < friends.length; i++){
            giftmap.put(friends[i], 0);
        }
        
        for(String gift : gifts){
            String[] giftStatus = gift.split(" ");
            status[map.get(giftStatus[0])][map.get(giftStatus[1])] += 1;
            giftstatus[map.get(giftStatus[0])] += 1;
            giftstatus[map.get(giftStatus[1])] -= 1;
        }
        
        for(int i = 0; i < status.length; i++){
            for(int j = 0; j < status[0].length; j++){
                if(i == j){
                    continue;
                }
                if(status[i][j] > status[j][i]){
                    giftmap.put(friends[i], giftmap.get(friends[i]) + 1);
                }
                else if(status[i][j] < status[j][i]){
                    giftmap.put(friends[j], giftmap.get(friends[j]) + 1);
                }else if(status[i][j] == status[j][i]){
                    
                    if(giftstatus[i] > giftstatus[j]){
                        giftmap.put(friends[i], giftmap.get(friends[i]) + 1);
                    }
                    
                    else if(giftstatus[j] > giftstatus[i]){
                        giftmap.put(friends[j], giftmap.get(friends[j]) + 1);
                    }
                }
            }
        }
        int max = 0;
        for(int value : giftmap.values()){
            if(value > max){
                max = value;
            }
        }
        return max/2;
                                    
    }
}