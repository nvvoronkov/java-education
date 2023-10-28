package algorithms;

public class Main {
    /*
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

    *
     * [Task 1]
     * Write a function that reverses a string. The input string is given as an array of characters s.
     * You must do this by modifying the input array in-place with O(1) extra memory.
     * <p>
     * Example 1:
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * <p>
     * Example 2:
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
    //Hello
    public static String reverseStringArray(final String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    *
     * [Task 2]
     * Given a sorted array of unique integers and a target integer, return true if there
     * exists a pair of numbers that sum to target, false otherwise.
     * This problem is similar to Two Sum. (In Two Sum, the input is not sorted).
     * <p>
     * For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13,
     * return true because 4 + 9 = 13.
    public static boolean hasPairWithSum(final int[] arr, final int target) {
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

    *
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * <p>
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * <p>
     * Return the maximum amount of water a container can store.
     * <p>
     * Notice that you may not slant the container.
     * <p>
     * Example 1:
     * <p>
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     * Example 2:
     * <p>
     * Input: height = [1,1]
     * Output: 1

    public static double maxSquareOfArray(final int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int result = 0;
        int square;
        while (left < right) {
            if (arr[left] <= arr[right]) {
                square = arr[left] * (right - left);
                left++;
            } else {
                square = arr[right] * (right - left);
                right--;
            }
            result = Math.max(result, square);
        }
        return result;
    }

    //Example 2: 2351. First Letter to Appear Twice
    //
    //Given a string s, return the first character to appear twice. It is guaranteed that the input will have a duplicate character.
    public char firstDuplicateChar(final String string) {
        char[] charArray = string.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : charArray) {
            if (set.contains(c)) {
                return c;
            } else {
                set.add(c);
            }
        }
        return '0';
    }*/
}
