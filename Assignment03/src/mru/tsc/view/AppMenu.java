package mru.tsc.view;

import java.util.Scanner;

import mru.tsc.exceptions.IncorrectInput;
import mru.tsc.exceptions.PlayersChecking;
import mru.tsc.model.ToyFormatting;

/**
 * Prompts the user with questions regarding how they want to run the program
 * @author Denzel Pascual & Ghoza Ghazali
 *
 */
public class AppMenu {
Scanner input;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	/**
	 * This method shows the main menu of the app
	 * 
	 * @return Returns an integer
	 */
	public int showAppMenu() {
		System.out.println("*********** WELCOME TO TOY STORE COMPANY ***********");
		System.out.println("\nHow May We Help You?");
		System.out.println("\n\t(1) Search Inventory and Purchase Toy");
		System.out.println("\t(2) Add New Toy");
		System.out.println("\t(3) Remove Toy");
		System.out.println("\t(4) Save & Exit");
		System.out.print("\nEnter Option: ");
		
		int option = input.nextInt();
		input.nextLine();
		
		//Checks to make sure the user's input is valid
		if(option != 1 && option != 2 && option != 3 && option != 4) {
			System.out.println(" ");
			System.out.println("------------ INCORRECT OPTION ------------");
			System.out.println(" ");
		} 
		
		return option;
		
	}
	
	/**
	 * This methods shows the subMenu to the user
	 * 
	 * @return Returns an integer entered by the user
	 */
	public int showSubMenu() {
		System.out.println("\nSearch Toy With: ");
		System.out.println("\n\t(1) Serial Number (SN)");
		System.out.println("\t(2) Toy Name");
		System.out.println("\t(3) Type");
		System.out.println("\t(4) Back to Main Menu");
		System.out.print("\nEnter Option: ");
		
		int option = input.nextInt();
		input.nextLine();
		
		//Checks to make sure the user's input is valid
		if(option != 1 && option != 2 && option != 3 && option != 4) {
			System.out.println(" ");
			System.out.println("------------ INCORRECT OPTION ------------");
			System.out.println(" ");
		} 
				
		return option;
	}
	
	/**
	 * Prompts the user for a Serial Number
	 * 
	 * @return
	 */
	public String promptSerialNumber() {
		System.out.print("\nEnter Toy Serial Number: ");
		String serialNum = input.nextLine().trim();
		return serialNum;
	}
	
	/**
	 * This method checks if the serial number is valid
	 * if toySerialNum does not equal null print it out
	 * otherwise print "toy not found"
	 * @param toySerialNum
	 * @throws Exception
	 */
	public void showSerialNumber(ToyFormatting toySerialNum) throws Exception{
		if(toySerialNum != null) {
			System.out.print(toySerialNum);
			System.out.println(" ");
		} else {
			System.out.println("Toy not Found");
		}
	}
	
	/**
	 * Prompts the user for the toy name
	 * @return
	 */
	public String promptToyName() {
		System.out.print("\nEnter Toy Name: ");
		String name = input.nextLine().trim();
		return name;
	}
	
	/**
	 * This method checks if the name is valid.
	 * if toyName does not equal null print it out
	 * otherwise print "Toy not found"
	 * 
	 * @param toyName
	 * @throws Exception
	 */
	public void showName(ToyFormatting toyName) throws Exception{
		if(toyName != null) {
			System.out.print(toyName);
		} else {
			System.out.println("Toy not Found");
		}
	}
	
	/**
	 * Prompts the user for what type of toy they are looking for
	 * by using char
	 * 
	 * @return Returns a char
	 */
	public char promptType() {
		System.out.println("\nSearch the Type of Toy: ");
		System.out.println("\n\t(A) Animals");
		System.out.println("\t(B) Board Games");
		System.out.println("\t(F) Figures");
		System.out.println("\t(P) Puzzles");
		System.out.println("\t(E) Exit to Sub Menu");
		System.out.print("\nEnter Toy Type: ");
		
		char option = input.nextLine().toUpperCase().charAt(0);
		
		//Checks to make sure the user's input is valid
		if(option != 'A' && option != 'B' && option != 'F' && option != 'P' && option != 'E') {
			System.out.println(" ");
			System.out.println("------------ INCORRECT OPTION ------------");
			System.out.println(" ");
		} 
		return option;
	}
	
	/**
	 * Prompts the user if they want to remove toy
	 * @return Returns the option Y/N
	 */
	public char promptRemoveToy() {
		System.out.println("Do you want to delete this toy? (Y/N)");
		System.out.print("Enter option: ");
		char option = input.nextLine().toUpperCase().charAt(0);
		
		//Checks to make sure the user's input is valid
		if(option != 'Y' && option != 'N') {
			System.out.println(" ");
			System.out.println("------------ INCORRECT OPTION ------------");
			System.out.println(" ");
		} 
				
		return option;
	}
	
	/**
	 * Prompts the user for the new toy's name
	 * @return Returns the toy name
	 */
	public String promptName() {
		System.out.print("What is the name of the toy: ");
		String toyName = input.next();
		return toyName;
	}
	
	/**
	 * Prompts the user for the new toy's brand
	 * @return Returns the toy brand
	 */
	public String promptBrand() {
		System.out.print("What is the brand of the toy: ");
		String toyBrand = input.next();
		return toyBrand;
	}
	
	/**
	 * Prompts the user for the toy's recommended age
	 * @return Returns valid integer
	 */
	public int promptAgeRecommendation() {
		System.out.print("What is the appropriate age: ");
		return valueChecker();
	}
	
	/**
	 * Prompts the user for the available toy for sale
	 * @return Returns valid integer
	 */
	public int promptAvailableToy() {
		System.out.print("How many toys are available for sale: ");
		return valueChecker();
	}
	
	/**
	 * Prompts the user for the toy's price
	 * @return Returns the valid price
	 */
	public double promptPrice() {
		boolean inputValid = false;
		String price;
		double toyPrice = 0;
		while(inputValid == false) {
			do {
				input.nextLine();
				System.out.print("What is the price of the toy: ");
				price = input.nextLine();
				toyPrice = Double.parseDouble(price);
				inputValid = true;
			} while(price == null);
			try {
				priceChecker(toyPrice);
			} catch(IncorrectInput msg) {
				System.out.println(msg.getMessage());
				System.out.println(" ");
				System.out.println("Press Enter to Continue");
				inputValid = false;
			}
		}
		return toyPrice;
	}
	
	/**
	 * Prompts the user for the toy's material
	 * @return Returns the toy's material
	 */
	public String promptMaterial() {
		System.out.print("What is the toy made out of: ");
		String toyMaterial = input.nextLine();
		return toyMaterial;
	}
	
	/**
	 * Prompts the user for the amount of players
	 * @return Returns the amount of players required
	 */
	public String promptPlayers() {
		boolean inputValidation = false;
		String s1;
		String s2;
		int minAmountPlayers = 0;
		int maxAmountPlayers = 0;
		while(inputValidation == false) {
			do {
				System.out.print("What is the minimum amount of players to play the game: ");
				s1 = input.nextLine();
				minAmountPlayers = Integer.parseInt(s1);
			} while(s1 == null);
		
				do {
					System.out.print("What is the maximum amount of players to play the game: ");
					s2 = input.nextLine();
					maxAmountPlayers = Integer.parseInt(s2);
					inputValidation = true;
				} while(s2 == null);
				
				try {
					playerChecker(minAmountPlayers, maxAmountPlayers);
				} catch(PlayersChecking msg) {
					System.out.println(msg.getMessage());
					System.out.println(" ");
					System.out.println("Press Enter to Continue");
					inputValidation = false;
				}
			}
		String rangeOfPlayers = "" + minAmountPlayers + "-" + maxAmountPlayers;
		return rangeOfPlayers;
	}
	
	/**
	 * Prompts the user for the toy's designer
	 * @return Returns the name of the designer
	 */
	public String promptDesigner() {
		System.out.print("Enter the Designer's Names(Use ',' to seperate the names if there is more than one name): " );
		String designerName = input.next();
		return designerName;
	}
	
	/**
	 * Checks if the user's input is a valid integer
	 * @return Returns the integer
	 */
	public int valueChecker() {
		int i = 0;
		boolean validValue = false;
		while(validValue == false) {
			if(input.hasNextInt()) {
				i = input.nextInt();
				input.nextLine();
				validValue = true;
			} else {
				System.out.println("Incorrect input");
				System.out.println("Please input an integer");
				input.nextLine();
			}
		}
		return i;
	}
	
	/**
	 * Checks if the price is negative or not
	 * @param p - User's input for price
	 * @return Returns the price of the toy
	 * @throws IncorrectInput
	 */
	public double priceChecker(double p) throws IncorrectInput {
		//Checks if user input is not negative
		if(p < 0) {
			//Prompts the user if the price is negative
			throw new IncorrectInput();
		}
		return p;
	}
	
	/**
	 * Checks if the amount of player is correct
	 * @param min - user's input minimum amount of players
	 * @param max - user's input maximum amount of players
	 * @throws PlayersChecking
	 */
	public void playerChecker(int min, int max) throws PlayersChecking  {
		//Checks if user input minimum amount of players is not greater than the maximum
		if(max < min) {
			//Prompts the user if the minimum amount of players is greater than the maximum amount
			throw new PlayersChecking();
		}
	}
}
