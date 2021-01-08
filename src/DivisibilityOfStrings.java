import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// marked

public class DivisibilityOfStrings {
    public static void main(String[] args) {
        // https://leetcode.com/discuss/general-discussion/680341/Divisibility-of-Strings
        DivisibilityOfStrings s = new DivisibilityOfStrings();
        System.out.println(s.solve("bcdbcdbcd", "bcdbcd"));
        System.out.println(s.solve("bcdbcdbcdbcd", "bcdbcd"));
        System.out.println(s.solve("bcdbcdbcdbcd", "bcd"));
    }

    private int solve(String s, String t) {
        // Check if divisible
        if (s.length() % t.length() > 0) {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i % t.length())) {
                return -1;
            }
        }

        // Factor for smallest substring
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (t.charAt(j) != t.charAt(j % (i + 1))) {
                    break;
                } else if (j == t.length() - 1) {
                    return i + 1;
                }
            }
        }

        return -1;
    }

    private int solve1(String s, String t) {
        List<Character> sub = new ArrayList<>();

        int res = -1;
        boolean factorable = false;

        for (char c : t.toCharArray()) {
            sub.add(c);

            factorable = factor(sub, s);
            factorable &= factor(sub, t);

            if (factorable && res == -1) {
                res =  sub.size();
            }
        }

        if (!factorable) {
            return  -1;
        }

        return res;
    }

    private boolean factor(List<Character> sub, String s) {
        StringBuilder builder = new StringBuilder();
        while (builder.length() < s.length()) {
            for (char c1 : sub) {
                builder.append(c1);
            }
        }

        return builder.length() == s.length() && builder.toString().equals(s);
    }
}
