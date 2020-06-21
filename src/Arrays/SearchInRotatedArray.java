package Arrays;

/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

        (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
        You are given a target value to search. If found in the array return its index, otherwise return -1.
        You may assume no duplicate exists in the array.
        Your algorithm's runtime complexity must be in the order of O(log n).

        Example 1:

        Input: nums = [4,5,6,7,0,1,2], target = 0
        Output: 4
        Example 2:

        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1*/

public class SearchInRotatedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int midPoint = (end + start) / 2;
            if (nums[midPoint] > nums[end]) {
                start = midPoint + 1;
            } else {
                end = midPoint;
            }
        }

        int pivot = start;

        if (target == nums[pivot]) {
            return pivot;
        }
        if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, pivot, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, pivot, target);
        }
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int midPoint = (start + end) / 2;
            if (target == nums[midPoint]) {
                return midPoint;
            }
            if (target > nums[midPoint]) {
                start = midPoint + 1;
            } else {
                end = midPoint - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
