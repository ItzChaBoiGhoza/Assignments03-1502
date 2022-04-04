package mru.tsc.exceptions;

public class PlayersChecking extends Exception{
	public PlayersChecking() {
		super("The minimum amount of players is greater than the maximum amount of players");
	}
}
