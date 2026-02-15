//Meeting Rooms


import java.util.Arrays;

class Solution {
    static boolean canAttend(int[][] arr) {
        // 1. If there's only one meeting or none, you can always attend
        if (arr == null || arr.length <= 1) {
            return true;
        }

        // 2. Sort the meetings by their start time
        // Using a Lambda expression to compare the first element of each row
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Iterate through the sorted meetings starting from the second one
        for (int i = 1; i < arr.length; i++) {
            // If the current meeting starts BEFORE the previous meeting ends, 
            // there is an overlap.
            if (arr[i][0] < arr[i - 1][1]) {
                return false;
            }
        }

        // 4. If we finish the loop without returning false, all meetings are clear
        return true;
    }
}