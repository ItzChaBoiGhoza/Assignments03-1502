package mru.tsc.model;

public class Puzzles extends ToyFormatting{
	
	/*
	 * This class is used to create puzzle objects.
	 * The puzzle-type can either be Mechanical, Cryptic, Logic, Trivia, or Riddle.
	 * M, C, L, T, R
	 */
	
	
	char puzzleType;
	/**
	 * Constructor used to create the puzzle object.
	 * Arguments from the ToyFormatting superclass
	 * 
	 * @param SN
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param type
	 * @param type
	 */
	
	public Puzzles(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String puzzleType) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		this.puzzleType = puzzleType.charAt(0);
	}

	public char getPuzzleType() {
		return puzzleType;
	}

	public void setPuzzleType(char puzzleType) {
		this.puzzleType = puzzleType;
	}
	
	// ToString method, allows the puzzle object to appear in a readable form
	public String toString() {
		return "Category:Puzzles, Serial Number: " + SN + ", Name: " + name + ", Brand: " + brand +
				", Price: " + price + ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
				", Puzzle Type: " + puzzleType;
	}
	
	// This method creates the format for the puzzle class
	public String format() {
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropriate + ";" + puzzleType;
	}

}
