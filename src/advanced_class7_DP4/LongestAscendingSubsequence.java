package advanced_class7_DP4;
/**
 * 
 * @author @Yifeng
 * Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.

	Assumptions
	
	A is not null
	Examples
	Input: A = {5, 2, 6, 3, 4, 7, 5}
	Output: 4
	Because [2, 3, 4, 5] is the longest ascending subsequence.
 */
/*
 * time = O(n ^ 2)
 * space = O(n)
 */
// M[i] represents length of longest ascending sub-sequence 
// from 0th to i-th element(including i-th element)
public class LongestAscendingSubsequence {
	public int longest(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int[] M = new int[array.length];
		// Base case
		M[0] = 1;
		int result = M[0]; //if array.length == 1, loop is useless
		for (int i = 1; i < array.length; i++) {
			boolean existed = false; // must set out of inner loop !!!
									 // if set in inner loop, for each j it will check
								     // and if array[i] < array[j] happen in the middle
			                         // partial solution will be covered by 1
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j]) {
					existed = true;
					M[i] = Math.max(M[j] + 1, M[i]);
				}
				if (!existed) {
					M[i] = 1;
				}
			}
			result = Math.max(result, M[i]);
		}
		return result;
	}
}

