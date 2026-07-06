//////////////////////////-----------
import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> stack = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        stack.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int a = intervals[i][0], b = intervals[i][1];
            int[] last = stack.get(stack.size() - 1);
            int x = last[0], y = last[1];

            if (x <= a && b <= y) continue;

            stack.add(intervals[i]);
        }

        return stack.size();
    }
}