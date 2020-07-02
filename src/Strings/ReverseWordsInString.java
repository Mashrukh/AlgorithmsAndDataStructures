package Strings;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
        String[] arr = s.split(" ");
        return reverse(arr);
    }

    private static String reverse(String[] arr) {
        int end = arr.length - 1;
        int start = 0;

        while (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String test = " a good   example ";
        System.out.println(reverseWords(test));
    }
}
