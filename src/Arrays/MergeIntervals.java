package Arrays;

/*Given a collection of intervals, merge all overlapping intervals.

        Example 1:

        Input: [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

        Example 2:
        Input: [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.*/

import java.util.Arrays;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int length = intervals.length;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i - 1][0] && intervals[i][0] <= intervals[i - 1][1]
                    && intervals[i][1] >= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = intervals[i][1];
                //mark the previous index so that it is known to be unused
                intervals[i - 1][0] = Integer.MAX_VALUE;
                intervals[i - 1][1] = Integer.MAX_VALUE;
                length--;

            } else if (intervals[i][0] >= intervals[i - 1][0] && intervals[i][0] <= intervals[i - 1][1]
                    && intervals[i][1] >= intervals[i - 1][0] && intervals[i][1] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = intervals[i - 1][1];
                //mark the previous index so that it is known to be unused
                intervals[i - 1][0] = Integer.MAX_VALUE;
                intervals[i - 1][1] = Integer.MAX_VALUE;
                length--;

            }
        }

        int result[][] = new int[length][2];
        int index = 0;
        for (int j = 0; j < intervals.length; j++) {
            if (intervals[j][0] != Integer.MAX_VALUE && intervals[j][1] != Integer.MAX_VALUE) {
                result[index][0] = intervals[j][0];
                result[index][1] = intervals[j][1];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4}, {2, 3}};
        //Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] result = merge(intervals);
        printArray(result);
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][0] + " ");
            System.out.print(arr[i][1]);
            System.out.println();
        }
    }
}
