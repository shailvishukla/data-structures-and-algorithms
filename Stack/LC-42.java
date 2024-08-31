// Trapping rain water

import java.io.*;

public class Main {

    static class Solution {
        public int[] getMaxLeft(int[] arr, int len) {
            int[] res = new int[len];
            res[0] = arr[0];
            for (int i = 1; i < len; i++) {
                res[i] = Math.max(arr[i], res[i - 1]);
            }
            return res;
        }

        public int[] getMaxRight(int[] arr, int len) {
            int[] res = new int[len];
            res[len - 1] = arr[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                res[i] = Math.max(arr[i], res[i + 1]);
            }
            return res;
        }

        public int trap(int[] arr) {
            int len = arr.length;
            int[] maxLeft = new int[len];
            int[] maxRight = new int[len];
            int sum = 0;

            maxLeft = getMaxLeft(arr, len);
            maxRight = getMaxRight(arr, len);

            for (int i = 0; i < len; i++) {
                sum += Math.min(maxLeft[i], maxRight[i]) - arr[i];
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        // Test case 1
        int[] heights1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution solution = new Solution();
        int result1 = solution.trap(heights1);
        System.out.println("Water trapped (Test case 1): " + result1); // Output: 6

        // Test case 2
        int[] heights2 = {4, 2, 0, 3, 2, 5};
        int result2 = solution.trap(heights2);
        System.out.println("Water trapped (Test case 2): " + result2); // Output: 9

        // Test case 3
        int[] heights3 = {3, 0, 2, 0, 4};
        int result3 = solution.trap(heights3);
        System.out.println("Water trapped (Test case 3): " + result3); // Output: 7

        // Test case 4
        int[] heights4 = {2, 0, 2};
        int result4 = solution.trap(heights4);
        System.out.println("Water trapped (Test case 4): " + result4); // Output: 2
    }
}
