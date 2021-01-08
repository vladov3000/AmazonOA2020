public class SlowestKeyPress {

    private static class IntTuple {
        public int first;
        public int second;

        public IntTuple(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        // https://leetcode.com/discuss/interview-question/945676/Amazon-or-OA-or-Slowest-Key-Press
        SlowestKeyPress s = new SlowestKeyPress();
        System.out.println(s.solve(4, new IntTuple[] {
                new IntTuple(0, 2),
                new IntTuple(1, 5),
                new IntTuple(0, 9),
                new IntTuple(2, 15),
        }));

    }

    private char solve(int num, IntTuple[] keyTimes) {
        int res = 0;
        int max = keyTimes[0].second;

        for (int i = 1; i < keyTimes.length; i++) {
            IntTuple cur = keyTimes[i];
            IntTuple prev = keyTimes[i-1];
            int deltaTime = cur.second - prev.second;

            if (deltaTime > max) {
                res = cur.first;
                max = deltaTime;
            }
        }

        return (char) (res + (int) 'a');
    }
}
