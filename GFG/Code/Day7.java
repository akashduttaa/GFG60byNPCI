
// Find H-Index


class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        // buckets[i] will store the number of papers with 'i' citations
        // we use n+1 to account for papers with >= n citations
        int[] buckets = new int[n + 1];

        // 1. Fill the buckets
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }

        // 2. Iterate backwards from n to 0
        int count = 0;
        for (int i = n; i >= 0; i--) {
            // Add papers that have at least 'i' citations
            count += buckets[i];
            
            // If we have at least 'i' papers with 'i' or more citations, 
            // then 'i' is our H-index
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }
}