package Yatzy;

import java.util.List;

public class game {
	public static final int min = 1;
	public static final int max = 6;
	
	public static void main(String[] args){
		menuInput();
		run();
	}
	
	public static void run(){
		Dice dice = new Dice();
		dice.ThrowDie(min,max);
		
		//Call ThrowDices
	}
	
	//Method that throws a specified amount of dices
	public List<Dice> ThrowDices(int times){
		//Array to store the dices
		
		//returns the dice array
		return null;
		
	}
	
	public void showMenu(int choice){
		//TODO Implement menu
	}
	
	public static int menuInput(){
		//TODO Implement menu
		return 0;
	}
}
