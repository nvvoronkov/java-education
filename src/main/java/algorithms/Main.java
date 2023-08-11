package algorithms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        Main.squareArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * Given an integer array nums sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     * Example 2:
     * <p>
     * Input: nums = [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     *
     * @param arr
     * @return
     */
    public static int[] squareArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}
