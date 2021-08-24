package Shuffling;

import java.util.Arrays;

/**
 * Knuth Shuffle
 * 
 * Proposition: [Fisher-Yates 1938] Knuth shuffling algorithms produces a
 * uniformly random permutation of the input array in linear time.
 * 
 * Steps: In iteration i, pick integer r between 0 and i uniformly at random.
 * Swap a[i] and a[r].
 */
public class Knuth_Shuffle {

	private Knuth_Shuffle() {
	}

	public static void shuffle(Comparable[] a) {
		int N = a.length;

		for (int i = 0; i < N; i++) {
			int r = (int) (Math.random() * (i + 1));
			System.out.println(r);
			exch(a, i, r);
		}
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	// Test Client
	public static void main(String[] args) {
		String[] cards = { "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C" };
		System.out.println("Before Shuffle:\n" + Arrays.toString(cards));
		Knuth_Shuffle.shuffle(cards);
		System.out.println("After Shuffle:\n" + Arrays.toString(cards));
	}
}
