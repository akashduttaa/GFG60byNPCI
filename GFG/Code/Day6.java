// Form the Largest Number 

import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        // 1. Convert integer array to String array
        String[] strs = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strs[i] = String.valueOf(arr[i]);
        }

        // 2. Sort strings with a custom comparator
        // Compare (b + a) to (a + b) for descending order
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // 3. Handle the case where all numbers are zero
        if (strs[0].equals("0")) {
            return "0";
        }

        // 4. Build the final large string
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }
}