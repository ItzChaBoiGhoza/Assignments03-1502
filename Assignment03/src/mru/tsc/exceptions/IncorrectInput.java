package mru.tsc.exceptions;

public class IncorrectInput extends Exception{
	public IncorrectInput() {
		super("Price cannot be negative");
	}
}
