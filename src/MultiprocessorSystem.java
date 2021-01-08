import java.util.*;

public class MultiprocessorSystem {
    public static void main(String[] args) {
        // https://leetcode.com/discuss/interview-question/945673/Amazon-or-OA-or-Multiprocessor-System
        MultiprocessorSystem s = new MultiprocessorSystem();
        System.out.println(s.solve(5, new int[] {3, 1, 7, 2, 4}, 15));
    }

    private int solve(int num, int[] abilities, int processes) {
        List<Integer> abilitiesList = new ArrayList<Integer>();
        for (int i : abilities) abilitiesList.add(i);

        Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        q.addAll(abilitiesList);

        int res = 0;
        while (processes > 0) {
            int maxAbility = q.poll();
            q.add(maxAbility / 2);

            processes -= maxAbility;
            res++;
        }

        return res;
    }
}
