import java.util.Arrays;

class Solution {
    public int solution(int[] money) {
        int[] firstDp = new int[money.length];
        int[] notFirstDp = new int[money.length];

        firstDp[0] = money[0];
        firstDp[1] = money[0];

        notFirstDp[0] = 0;
        notFirstDp[1] = money[1];

        int answer = 0;
        if(money.length == 3) {
            if(money[0] > money[1]) {
                answer = money[0];
            }
            if(money[2] > answer){
                answer = money[2];
            }
            return answer;
        }

        for(int i = 2; i < money.length; i++) {
            notFirstDp[i] = Math.max(notFirstDp[i-1], money[i] + notFirstDp[i-2]);
            if(notFirstDp[i] > answer) {
                answer = notFirstDp[i];
            }

            if(i == money.length - 1) {
                break;
            }
            firstDp[i] = Math.max(firstDp[i-1], money[i] + firstDp[i-2]);
            if(firstDp[i] > answer) {
                answer = firstDp[i];
            }
        }
        return answer;
    }
}