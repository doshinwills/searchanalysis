package com.doshin.searchanalysis;

public class InterpolationSearch {

	public static int search(int[] array, int searchValue) {

		if (searchValue < array[0] && array[array.length - 1] < searchValue)
			return -1;
		int counter = 0;
		int first = 0;
		int last = array.length - 1;
		while (first <= last) {
			int mid = first
					+ ((last - first) / (array[last] - array[first]) * (searchValue - array[first]));
			if (searchValue < array[mid])
				last = mid - 1;
			else if (array[mid] < searchValue)
				first = mid + 1;
			else {
				System.out.print(counter + "\n");
				return mid;
			}
			counter++;

		}
		
		System.out.print(counter + "\n");
		return -1;
	}

}
