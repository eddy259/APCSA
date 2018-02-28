package Unit9;

public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] ranks = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
		String[] suits = {"clubs", "spades", "hearts", "diamonds"};
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		
		
		Deck testdeck = new Deck(ranks, suits, values);
		
		if (!testdeck.isEmpty()){
			System.out.println("not empty");
		}
		
		
		
	}
}