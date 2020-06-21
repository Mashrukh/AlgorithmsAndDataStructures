package Arrays;

    /*Given an array nums, there is a sliding window of size k which is moving from the very left of the array to
    the very right. You can only see the k numbers in the window. Each time the sliding window moves right by
    one position. Return the max sliding window.

        Follow up:
        Could you solve it in linear time?
        Example:

        Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
        Output: [3,3,5,5,6,7]
        Explanation:

        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7      3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7

        Constraints:
        1 <= nums.length <= 10^5
        -10^4 <= nums[i] <= 10^4
        1 <= k <= nums.length*/

public class FindMaximumInSlidingArray {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] window = new int[k];
        int[] result = new int[nums.length - k + 1];
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = 0; j < window.length; j++) {
                window[j] = nums[j + i];
                maxNum = Math.max(maxNum, window[j]);
            }
            result[i] = maxNum;
            maxNum = Integer.MIN_VALUE;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("hi");
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }
}
