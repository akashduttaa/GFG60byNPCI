// Maximum number of overlapping Intervals


class Solution {
    public static int overlapInt(int[][] arr) {
        // 1. Find the maximum time point to define the size of our frequency array
        int maxTime = 0;
        for (int[] interval : arr) {
            maxTime = Math.max(maxTime, interval[1]);
        }

        // 2. Create a difference array. 
        // We use maxTime + 2 to safely handle end + 1 indices.
        int[] diff = new int[maxTime + 2];

        // 3. Mark the start and end of each interval
        for (int[] interval : arr) {
            int start = interval[0];
            int end = interval[1];
            
            diff[start]++;      // An interval starts here
            diff[end + 1]--;    // The interval ends AFTER this point
        }

        // 4. Calculate the prefix sum and track the maximum
        int maxOverlap = 0;
        int currentOverlap = 0;
        
        for (int i = 0; i <= maxTime; i++) {
            currentOverlap += diff[i];
            if (currentOverlap > maxOverlap) {
                maxOverlap = currentOverlap;
            }
        }

        return maxOverlap;
    }
}