package lesson.five;

import java.util.Arrays;

public class Task {

    /**
     * [Task 1]
     * Write a function that reverses a string. The input string is given as an array of characters s.
     * You must do this by modifying the input array in-place with O(1) extra memory.
     * <p>
     * Example 1:
     * Input: s = ["h","e","l","l","o"]Output: ["o","l","l","e","h"]
     * <p>
     * Example 2:
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     */
    public String[] reverseStringArray(String[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;



//        Arrays.stream(arr).map(String::toLowerCase)
//                .distinct()
//                .forEach(index -> arr.);
//        return arr;
    }

    /**
     * [Task 2]
     * Given a sorted array of unique integers and a target integer, return true if there exists a pair of numbers that sum to target, false otherwise. This problem is similar to Two Sum. (In Two Sum, the input is not sorted).
     * <p>
     * For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, return true because 4 + 9 = 13.
     */
    public boolean hasPairWithSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
