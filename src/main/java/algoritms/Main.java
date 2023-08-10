package algoritms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] array = new int[]{-4, -1, 0, 3, 10};
        //System.out.println(Arrays.toString(main.squareArray(array)));
        System.out.println(Arrays.toString(main.squareArrayOn(array)));

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
     * <p>
     * <p>
     * 2 ч, 19 мин, 52 с
     *
     * @param arr
     * @return arr
     */

    public int[] squareArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }

    //[-4,-1,0,3,10]

    public int[] squareArrayOn(int[] arr) {
        int[] newArr = new int[arr.length];
        int right = arr.length - 1;
        int left = 0;
        for (int i = newArr.length - 1; i != 0; i--) {
            if (Math.pow(arr[left], 2) > Math.pow(arr[right], 2)) {
                newArr[i] = (int) Math.pow(arr[left], 2);
                left++;
            } else if (Math.pow(arr[left], 2) < Math.pow(arr[right], 2)) {
                newArr[i] = (int) Math.pow(arr[right], 2);
                right--;
            } else if (Math.pow(arr[left], 2) == Math.pow(arr[right], 2)) {
                newArr[i] = (int) Math.pow(arr[left], 2);
                left++;
            } else {
                newArr[i] = (int) Math.pow(arr[left], 2);
                left++;
            }
        }
        return newArr;
    }
}
