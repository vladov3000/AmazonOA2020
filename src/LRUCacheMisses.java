import java.util.*;

public class LRUCacheMisses {
    public static void main(String[] args) {
        // https://leetcode.com/discuss/interview-question/992179/Amazon-or-OA-2021-or-LRU-Cache-Misses
        LRUCacheMisses s = new LRUCacheMisses();
        System.out.println(s.solve(6, new int[] {1,2,1,3,1,2}, 2));
    }

    private int solve(int num, int[] pages, int maxCacheSize) {
        Queue<Integer> lru = new LinkedList<>();
        int misses = 0;
        for (int page : pages) {
            lru.add(page);
            if (lru.size() > maxCacheSize) {
                misses++;
                lru.poll();
            }
            // System.out.println(Arrays.toString(lru.toArray()));
        }

        return misses;
    }
}
