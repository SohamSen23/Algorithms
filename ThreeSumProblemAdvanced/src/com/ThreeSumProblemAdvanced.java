package com;

/**
 * 
 * This is an advanced version of the three sum problem. From an array of
 * numbers, find three numbers whose sum is zero Instead of using three tiered
 * nested loops which would have yielded a horrid N^3 complexity, we'll use one
 * nested loop and a binary search
 *
 */
public class ThreeSumProblemAdvanced {
	private int[] arr;

	public ThreeSumProblemAdvanced(int[] arr) {
		this.arr = arr;
	}

	private int binarySearch(int first, int last, int number) {
		int middle = (first + last) / 2;
		while (first <= last) {
			if (arr[middle] < number) {
				first = middle + 1;
			} else if (arr[middle] == number) {
				return middle;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}
		return -1;
	}

	private String findThreeSum(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int twoSum = -(arr[i] + arr[j]);
				int binarySearchResult = this.binarySearch(0, arr.length - 1, twoSum);
				if (binarySearchResult != -1)
					return arr[i] + ", " + arr[j] + " and " + twoSum + " make a zero sum";
			}
		}
		return "Not Found!";
	}

	public static void main(String args[]) {
		 int[] falseArr = { 30, -40, -20, -12, 41, 0, 13, 5 };
		//int[] trueArr = { 30, -40, -20, -10, 40, 0, 10, 5 };
		ThreeSumProblemAdvanced threeSumProblemAdvanced = new ThreeSumProblemAdvanced(falseArr);
		System.out.println(threeSumProblemAdvanced.findThreeSum(falseArr));
	}
}
