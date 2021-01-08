import java.util.Arrays;

// marked

public class WinningSequence {
    public static void main(String[] args) {
        // https://leetcode.com/discuss/interview-question/945674/Amazon-or-OA-or-Winning-Sequence
        WinningSequence s = new WinningSequence();
        System.out.println(Arrays.toString(s.solve(5, 3, 10)));
        System.out.println(Arrays.toString(s.solve(5, 3, 10)));
        System.out.println(Arrays.toString(s.solve(7, -1, 20)));
    }

    private int[] solve(int num, int lowerEnd, int upperEnd) {
        int[] res = new int[num];
        res[0] = upperEnd - 1;
        res[1] = upperEnd;
        for (int i = 2; i < num; i++) {
            if (res[i - 1] - 1 < lowerEnd) {
                return new int[] {-1};
            }
            res[i] = res[i - 1] - 1;
        }
        return res;
    }
}
