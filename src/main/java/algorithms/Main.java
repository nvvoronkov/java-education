package algorithms;

import java.util.Arrays;

final public class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        Main.squareArray(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1, 0, -3, -5, 0, 2};
        Main.signCount(arr1);
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
     *
     */
    public static int[] squareArray(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }

    //[1,0,-3,-5,0,2] 0 - не изменение знака => 2
    //[1,-3,3,-5,0,2] 0 - не изменение знака => 4
    //[1,0,0,-2] => 1

    public static int signCount(final int[] arr) {
         int temp = arr[0];
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            if (temp < 0 && arr[i] > 0) {
                count++;
            } else if (temp > 0 && arr[i] < 0) {
                count++;
            }
            temp = arr[i];
        }
        return count;
    }
}
