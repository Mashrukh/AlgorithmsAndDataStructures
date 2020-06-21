package Arrays;

// Given a sorted array of integers, return the index of the given key. Return -1 if the key is not found.
public class BinarySearchOnSortedArray {

    public static int search(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 && arr[0] == target) {
            return 0;
        }

        int start = 0;
        int end = arr.length - 1;
        int midpoint = (start + end) / 2;

        while (start <= end) {
            if (arr[midpoint] == target) {
                return midpoint;
            }

            if (target < arr[midpoint]) {
                end = midpoint - 1;
                midpoint = (start + end) / 2;
            } else {
                start = midpoint + 1;
                midpoint = (start + end) / 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int target = 2;
        System.out.println(search(arr, target));
    }
}
