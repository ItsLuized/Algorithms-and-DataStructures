package Shuffling;

import java.lang.Math;
import java.util.Arrays;

/**
 * Proposition: Shuffle sort produces a uniformly random permutation of the
 * input array, provided no duplicate values.
 * 
 * Steps: Generate a random real number for each array entry. Sort the array.
 * 
 * Drawback: Need to pay cost of sort.
 * 
 * Can we do better? Faster way to Shuffle? Yes. Knuth Shuffle
 */
public class ShuffleSort {

	private ShuffleSort() {
	}

	public static void suffle(Comparable[] a) {
		int N = a.length;
		double[] randNum = new double[N];

		// Generate random numbers for each element of the array
		for (int i = 0; i < N; i++) {
			randNum[i] = Math.random();
		}

		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (randNum[j] < randNum[j - 1]) {
					exchDouble(randNum, j, j - 1);
					exch(a, j, j - 1);
				}
			}
		}

	}

	private static void exchDouble(double[] a, int i, int j) {
		double swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	// Test Client
	public static void main(String[] args) {
		String[] cards = { "8C", "6C", "9C", "7C", "2C", "4C", "10C", "5C", "3C" };
		System.out.println("Before shuffle:\n" + Arrays.toString(cards));
		ShuffleSort.suffle(cards);
		System.out.println("After shuffle:\n" + Arrays.toString(cards));
	}
}