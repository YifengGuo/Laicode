package class1Sort;

/**
 * 
 * @author Yifeng
 * Given an array of balls, where the color of the balls can only be Red, Green or Blue, 
 * sort the balls such that all the Red balls are grouped on the left side, 
 * all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. 
 * (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

	Examples
	
	{0} is sorted to {0}
	{1, 0} is sorted to {0, 1}
	{1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
	Assumptions
	
	The input array is not null.
	Corner Cases
	
	What if the input array is of length zero? In this case, we should not do anything as well.
 *
 */
public class RainbowSort {
	public int[] rainbowSort(int[] array) {
		// Write your solution here.
		if (array == null || array.length == 0) {
			return array;
		}

		int lo = 0;
		int hi = array.length - 1;
		int cur = 0;

		while (cur <= hi) {
			if (array[cur] == -1) {
				swap(array, cur, lo);
				lo++;
				cur++;
			} else if (array[cur] == 0) {
				cur++;
			} else {
				swap(array, cur, hi);
				hi--;
			}
		}
		return array;
	}

	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
