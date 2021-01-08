import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumUniquePairs {
    public static void main(String[] args) {
        // https://leetcode.com/discuss/interview-question/372434
        TwoSumUniquePairs s = new TwoSumUniquePairs();
        System.out.println(s.solve(new int[] {1, 1, 2, 45, 46, 46}, 47));
        System.out.println(s.solve(new int[] {1, 1}, 2));
        System.out.println(s.solve(new int[] {1, 5, 1, 5}, 6));
    }

    private int solve(int[] nums, int target) {
        Map<Integer, Boolean> seen = new HashMap<>();
        int res = 0;

        for (int n : nums) {
            //System.out.println(seen);
            if (seen.containsKey(target - n)) {
                if (seen.get(target - n)) {
                    res++;
                    seen.put(target - n, false);
                }
            } else if (!seen.containsKey(n)) {
                seen.put(n, true);
            }
        }

        return res;
    }

    private int solve1(int[] nums, int target) {
        Set<Integer> comps = new HashSet<> ();

        for (int n : nums) {
            if (!comps.contains(n)) {
                comps.add(target - n);
            }
        }

        int res = 0;
        for (int n : nums) {
            if (comps.contains(n)) {
                res++;
                comps.remove(n);
            }
        }

        return res;
    }

}
