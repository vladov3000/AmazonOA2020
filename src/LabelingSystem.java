import java.util.*;

public class LabelingSystem {
    public static void main(String[] args) {
        // https://leetcode.com/discuss/interview-question/992180/Amazon-or-OA-2020-or-Labeling-System
        LabelingSystem s = new LabelingSystem();
        System.out.println(s.solve("baccc", 2));
        System.out.println(s.solve("baccc", 1));
        System.out.println(s.solve("baasdkfhadksfkhlsadhkfsadkfccc", 2));
    }

    private int charToInt(char c) {
        return (int) c - (int) 'a';
    }

    private String solve(String originalLabel, Integer charLimit) {
        originalLabel = originalLabel.toLowerCase();

        int[] freqs = new int[26];
        for (char c : originalLabel.toCharArray())  {
            freqs[charToInt(c)]++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = freqs.length - 1; i > -1; i--) {
            for (int j = 0; j < Math.min(charLimit, freqs[i]); j++) {
                res.append((char) (i + (int) 'a'));
            }
        }
        return res.toString();
    }

    private String solve1(String originalLabel, Integer charLimit) {
        List<Character> arr = new ArrayList<Character>();
        for (char c : originalLabel.toCharArray()) arr.add(c);
        arr.sort(Collections.reverseOrder());

        StringBuilder res = new StringBuilder();
        int streak = 0;
        for (int i = 0; i < arr.size(); i++) {

            streak = (i > 0 && arr.get(i) == arr.get(i - 1)) ? streak + 1 : 0;

            if (streak < charLimit) res.append(arr.get(i));
        }
        return res.toString();
    }
}
