// Missing Element in Range 

import java.util.*;

class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Use a boolean array to track numbers present in arr
        // The constraint is 10^5, so an array of 100001 is sufficient
        boolean[] present = new boolean[100001];
        
        // 1. Mark all elements existing in the input array
        for (int num : arr) {
            // Only mark if it's within the possible range of our boolean array
            if (num <= 100000) {
                present[num] = true;
            }
        }
        
        // 2. Iterate through the target range [low, high]
        for (int i = low; i <= high; i++) {
            // 3. If the number is NOT present, add it to our list
            if (i > 100000 || !present[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}