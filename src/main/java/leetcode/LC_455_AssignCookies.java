package leetcode;

import java.util.Arrays;

public class LC_455_AssignCookies {

    /*
     * g: greed factor
     * s: cookie
     * */
    public int findContentChildren(int[] g, int[] s) {
        int contentChildes = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int gIdx = 0;
        int sIdx = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (g[gIdx] <= s[sIdx]) {
                contentChildes++;
                gIdx++;
                sIdx++;
            } else {
                sIdx++;
            }
        }

        return contentChildes;
    }
}
