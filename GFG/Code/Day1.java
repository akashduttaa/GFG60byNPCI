// Chocolate Distribution Problem 


import java.util.*;

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // 1. If there are no students or packets, the difference is zero
        int n = arr.size();
        if (m == 0 || n == 0) {
            return 0;
        }

        // 2. Sort the array to group similar chocolate counts together
        Collections.sort(arr);

        // 3. Initialize minDiff with a very large value
        int minDiff = Integer.MAX_VALUE;

        // 4. Slide a window of size m across the sorted list
        // We stop when the end of the window (i + m - 1) reaches the end of the list
        for (int i = 0; i + m - 1 < n; i++) {
            // Calculate difference between the last and first element in the window
            int currentDiff = arr.get(i + m - 1) - arr.get(i);

            // Update minDiff if we found a smaller range
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }

        return minDiff;
    }
}