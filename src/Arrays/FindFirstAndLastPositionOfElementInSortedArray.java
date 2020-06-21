package Arrays;

    /*Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

    Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]*/

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;
    }

    public static int findStartingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int midPoint = (start + end) / 2;

            if (target <= nums[midPoint]) {
                end = midPoint - 1;
            } else {
                start = midPoint + 1;
            }
            if (nums[midPoint] == target) {
                index = midPoint;
            }
        }
        return index;
    }

    public static int findEndingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int midPoint = (start + end) / 2;

            if (target >= nums[midPoint]) {
                start = midPoint + 1;
            } else {
                end = midPoint - 1;
            }
            if (nums[midPoint] == target) {
                index = midPoint;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println("hello");
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }
}
