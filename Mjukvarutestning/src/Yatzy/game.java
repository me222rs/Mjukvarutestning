package Yatzy;

import java.util.ArrayList;
import java.util.List;

public class game {
	// fields
	public final int min = 1;
	public final int max = 6;
	public final int fiveDices = 5;
	public List<Dice> diceList = new ArrayList<Dice>();
	public int choice;
	public String choiceAsString;
	
	//start method
	public static void main(String[] args){
		game g = new game();
		Model m = null;
		View v = null;
		Controller c = new Controller(m,v);
		c.Start(m,v);
	}
}
