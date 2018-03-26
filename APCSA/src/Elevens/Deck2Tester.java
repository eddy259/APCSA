package Elevens;

public class Deck2Tester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] ranks = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
		String[] suits = {"clubs", "spades", "hearts", "diamonds"};
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		
		
		Deck2 testdeck = new Deck2(ranks, suits, values);
		
		System.out.println(testdeck.toString());
		
		System.out.println("\n\n\n");
		
		System.out.println(testdeck.deal());
		
		System.out.println("\n\n\n");
		
		testdeck.shuffle();
		
		System.out.println(testdeck.toString());
		
		if (!testdeck.isEmpty()){
			System.out.println("not empty");
		}
		
		
		
	}
}