import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EarliestTime {

    public static void main(String[] args) {
        // https://leetcode.com/discuss/interview-question/992156/Amazon-or-OA-or-Earliest-Time-To-Complete-Deliveries
        EarliestTime s = new EarliestTime();
        System.out.println(s.solve(2, new int[]{8,10}, new int[]{2,2,3,1,8,7,4,5}));
    }

    private int solve(int numOfBuildings, int[] buildingOpenTimes, int[] offloadTimes) {
        Arrays.sort(buildingOpenTimes);
        Arrays.sort(offloadTimes);

        int res = 0;
        for (int i = 0; i < buildingOpenTimes.length; i++) {
            int openTime = buildingOpenTimes[i];
            int offloadTime = offloadTimes[offloadTimes.length - 1 - i * 4];

            res = Math.max(res, openTime + offloadTime);
            // System.out.printf("%d %d %d\n", openTime, offloadTime, res);
        }

        return res;
    }
}
