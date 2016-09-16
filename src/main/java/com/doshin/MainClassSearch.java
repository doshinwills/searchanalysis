package com.doshin;

import java.util.Arrays;
import java.util.Random;

import com.doshin.searchanalysis.BinarySearch;
import com.doshin.searchanalysis.InterpolationSearch;

public class MainClassSearch {

	public static void main(String[] args) throws Exception {
		System.out.println("Binary Search Time in Nanos\tInterpolation Search Time in Nanos");
		for (int indexI = 10000; indexI < 50000; indexI+=100) {
			int[] arrayBinary = new int[1000 * indexI];
			int[] arrayInterpolation = new int[1000 * indexI];

			Random random = new Random();

			for (int indexJ = 0; indexJ < 1000 * indexI; indexJ++) {
				int value = random.nextInt();
				arrayBinary[indexJ] = value;
				arrayInterpolation[indexJ] = indexJ;
			}
			Arrays.sort(arrayBinary);
			Arrays.sort(arrayInterpolation);
			
			int searchValue = new Random().nextInt(1000 * indexI);
			
			BinarySearch.search(arrayBinary, arrayBinary[searchValue]);			
			InterpolationSearch.search(arrayInterpolation, arrayInterpolation[searchValue]);			

		}

	}

}
