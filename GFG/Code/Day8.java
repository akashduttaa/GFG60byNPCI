// Count Subarrays with given XOR


import java.util.HashMap;

class Solution {
    public long subarrayXor(int arr[], int k) {
        long count = 0;
        int currentXor = 0;
        
        // HashMap to store the frequency of prefix XORs
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: A prefix XOR of 0 has been seen once (before any elements)
        map.put(0, 1);
        
        for (int num : arr) {
            // Update the prefix XOR for the current element
            currentXor ^= num;
            
            // We need a prefix XOR 'target' such that: currentXor ^ target = k
            // This simplifies to: target = currentXor ^ k
            int target = currentXor ^ k;
            
            // If this target exists in our map, it means there are subarrays 
            // ending at the current index that XOR to k
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            
            // Store/Update the frequency of the current prefix XOR in the map
            map.put(currentXor, map.getOrDefault(currentXor, 0) + 1);
        }
        
        return count;
    }
}