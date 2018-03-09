package Unit9;

import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Deck2 {

	/**
	 * cards contains all the cards in the Deck2.
	 */
	private ArrayList<Card> cards;
	
	//Unit 9 - Array version of the Deck2
	//private Card[] cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size = 0;

	String[] ranks = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
	String[] suits = {"clubs", "spades", "hearts", "diamonds"};
	int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	/**
	 * Creates a new <code>Deck2</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck2(String[] ranks, String[] suits, int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		
		cards = new ArrayList<Card>();
		//this.ranks = ranks;
		//this.suits = suits;
		//this.values = values;
		
		/*
		for (int i = 1; i <= size; i++){
			//assumes Deck2 is 52
			//cards[i] = new Card(ranks[i%13], suits[i/13], values[i%13]);
		}
		*/
		
		for (int i = 0; i < suits.length; i++){
			for (int c = 0; c < ranks.length; c++){
				cards.add(new Card(ranks[c], suits[i], values[c])); 
			}
		}
		
		size = cards.size();
		
//		for(Card e: cards){
//			System.out.println(e.toString());
//		}
	}


	/**
	 * Determines if this Deck2 is empty (no undealt cards).
	 * @return true if this Deck2 is empty, false otherwise.
	 */
	public boolean isEmpty() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		if (size == 0){
			
			return true;
		}
		
		else{
			
			return false;
		}
		
	}

	/**
	 * Accesses the number of undealt cards in this Deck2.
	 * @return the number of undealt cards in this Deck2.
	 */
	public int size() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire Deck2.
	 */
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
		for(int k = this.size() - 1; k > 0; k--){
			int r = (int)(Math.random() * k);
			Card temp = cards.get(k);
			cards.set(k, cards.get(r));
			cards.set(r, temp);
			
		}
		
//		for(Card e: cards){
//			System.out.println(e.toString());
//		}
	}

	/**
	 * Deals a card from this Deck2.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		if (isEmpty() == true){
			System.out.println("No more cards to deal");
			return null;
		}
		else {
			size--;
			//size is length of the Deck2, so cards[size] is conveniently the index of the card you just removed after you size --
			return cards.get(size);
		}
	}

	/**
	 * Generates and returns a string representation of this Deck2.
	 * @return a string representation of this Deck2.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for(int i = 0;i < this.size();i++){
			rtn = rtn + cards.get(i).toString() + "\n";
		}
		
		rtn += "\n Dealt cards: \n";
		
		for(int i = this.size(); i < cards.size();i++){
			rtn = rtn + cards.get(i).toString() + "\n";  
		}
		
		if(this.size() == cards.size()){
			rtn = rtn + "No dealt cards";
		}
		
		//Unit 9 - modify to work with Arrays
		/*
		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire Deck2 is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire Deck2 is visible on console.
				rtn = rtn + "\n";
			}
		}
		*/

		rtn = rtn + "\n";
		return rtn;
	}
}