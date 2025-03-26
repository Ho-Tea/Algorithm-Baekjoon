
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(reader.readLine());
        int T = Integer.parseInt(reader.readLine());
        int B = Integer.parseInt(reader.readLine());
        int round = 1;
        int cumulativeTarget = 0;
        while (true) {
            int targetCountThisRound = round + 3;
            if (cumulativeTarget + targetCountThisRound >= T) {
                break;
            }
            cumulativeTarget += targetCountThisRound;
            round++;
        }
        int orderInRound = T - cumulativeTarget;
        int posInRound = 0;
        if (B == 0) {
            if (orderInRound == 1) {
                posInRound = 1;
            } else if (orderInRound == 2) {
                posInRound = 3;
            } else {
                posInRound = 4 + (orderInRound - 2);
            }
        } else {
            if (orderInRound == 1) {
                posInRound = 2;
            } else if (orderInRound == 2) {
                posInRound = 4;
            } else {
                posInRound = 4 + (round + 1) + (orderInRound - 2);
            }
        }

        int totalWordsBefore = 0;
        for (int r = 1; r < round; r++) {
            totalWordsBefore += (2 * r + 6);
        }
        int overallPosition = totalWordsBefore + posInRound -1;

        System.out.println(overallPosition % A);


    }
}