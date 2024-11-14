package SQLI;

import java.util.HashMap;
import java.util.Random;

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

public class CountingTriplets3 {
    public static int countTriplets(int[] arr, int d) {
        int n = arr.length;
        int count = 0;
        int[] remainders = new int[n];
        for (int i = 0; i < n; i++) {
            remainders[i] = (arr[i] % d + d) % d;
        }
        HashMap<Integer, Integer> remainderCounts = new HashMap<>();
        for (int remainder : remainders) {
            remainderCounts.put(remainder, remainderCounts.getOrDefault(remainder, 0) + 1);
        }
        for (int r1 = 0; r1 < d; r1++) {
            for (int r2 = r1 + 1; r2 < d; r2++) {
                int r3 = (d - (r1 + r2) % d) % d;
                if(r3 < r2) continue;
                if (r3 < r1) continue;
                if (r1 == r2 && r2 == r3)
                    count += remainderCounts.getOrDefault(r1, 0) * (remainderCounts.getOrDefault(r1, 0) - 1) * (remainderCounts.getOrDefault(r1, 0) - 2) / 6;
                else if (r1 == r2)
                    count += remainderCounts.getOrDefault(r1, 0) * (remainderCounts.getOrDefault(r1, 0) - 1) / 2 * remainderCounts.getOrDefault(r3, 0);
                else if (r2 == r3)
                    count += remainderCounts.getOrDefault(r1, 0) * remainderCounts.getOrDefault(r2, 0) * (remainderCounts.getOrDefault(r2, 0) - 1) / 2;
                else
                    count += remainderCounts.getOrDefault(r1, 0) * remainderCounts.getOrDefault(r2, 0) * remainderCounts.getOrDefault(r3, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 15, 23, 42, 56, 71, 84, 97, 105, 116, 135, 147, 159, 171};
        int d = 7;
        long before = System.nanoTime();
        System.out.println(countTriplets(arr, d));
        long after = System.nanoTime();
        System.out.println(after - before + " nanoseconds");
    }
}
