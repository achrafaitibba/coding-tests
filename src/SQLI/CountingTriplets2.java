package SQLI;

import java.util.HashMap;

/**
Problem 1: Counting Triplets
---------------------------
Description:
- Given an integer array arr[n] and integer value d
- Array is indexed from 1 to n
- Count distinct triplets (i,j,k) where:
  * 0 < i < j < k ≤ n
  * Sum of arr[i] + arr[j] + arr[k] is divisible by d

Constraints:
- 3 ≤ n ≤ 10³
- 1 ≤ arr[i] ≤ 10⁹
- 2 ≤ d ≤ 10⁶

Example:
arr = [3, 3, 4, 7, 8]
d = 5
Result = 3 (because of these triplets:
- (1,2,3): 3+3+4 = 10 divisible by 5
- (1,3,5): 3+4+8 = 15 divisible by 5
- (2,3,4): 3+4+8 = 15 divisible by 5)

*/

public class CountingTriplets2 {
    public static int countTriplets(int[] arr, int d) {
        int n = arr.length;
        int count = 0;
        for (int k = 0; k < n; k++) {
            HashMap<Integer, Integer> remainderCount = new HashMap<>();
            for (int j = 0; j < k; j++) {
                int remainder = (arr[j] % d + d) % d;
                int needed = (d - remainder) % d;
                count += remainderCount.getOrDefault(needed, 0);
                int current = (arr[k] % d + arr[j] % d) % d;
                remainderCount.put(current, remainderCount.getOrDefault(current, 0) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 15, 23, 42, 56, 71, 84, 97, 105, 116, 135, 147, 159, 171};
        int d = 7;

        long before = System.nanoTime();
        System.out.println(countTriplets(arr, d));
        long after = System.nanoTime();;
        System.out.println(after - before  + " nanoseconds");
    }
}
