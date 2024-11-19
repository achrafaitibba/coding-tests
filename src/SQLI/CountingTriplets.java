package SQLI;

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

public class CountingTriplets {

    public static int countTriplets(int[] arr, int d) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if ((arr[i] + arr[j] + arr[k]) % d == 0) {
                        count++;
                    }
                }
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
