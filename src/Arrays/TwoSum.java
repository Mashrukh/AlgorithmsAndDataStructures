package Arrays;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length < 2) {
            return result;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 9;
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
