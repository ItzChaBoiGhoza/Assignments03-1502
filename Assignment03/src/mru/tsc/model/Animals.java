package mru.tsc.model;

public class Animals extends ToyFormatting {
	
	String Material;
	/*
	 * char size can either be small, medium, large
	 * S, M, L
	 */
	char size;
	
	/**
	 * Constructor used to create the Animals object.
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
	public Animals (String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String materials, String size) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		Material = materials;
		this.size = size.charAt(0);
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	// ToString method, allows the Animals object to appear in a readable form
	@Override
	public String toString() {
		return "Category: Animal, Serial Number: " + SN + ", Name: " + name + ", Brand: " + brand + ", Price: " + price + ", Available Count: "
				+ availableCount + ", Age Appropraite: " + ageAppropriate + ", Material: " + Material + ", Size: " + size;
	}
	
	// This method creates the format for the Animals class
	public String format() {
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropriate + ";" + Material + ";" + size;
	}
	
	
	
	

}
