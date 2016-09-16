package com.doshin.searchanalysis;

public class BinarySearch {
	
	public static int search(int[] array, int searchValue) {
		int counter = 0;
		int first = 0;
		int last = array.length;
		while(first <= last) {
			int mid = first + (last - first)/2;
			if(searchValue < array[mid])
				last = mid -1;
			else if(array[mid] < searchValue)
				first = mid + 1;
			else {
				System.out.print(counter + "\t");
				return mid;
			}
			counter++;
		}
		System.out.print(counter + "\t");
		return -1;
	}

}
