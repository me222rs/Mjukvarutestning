package Yatzy;

import java.util.ArrayList;
import java.util.List;

public class game {
	//static fields
	public static final int min = 1;
	public static final int max = 6;
	public static final int max_dices = 5;
	public static List<Dice> diceList = new ArrayList<Dice>();
	
	//start method
	public static void main(String[] args){
		//menuInput();
		run();
	}
	//run method for the game
	public static void run(){
		//Call ThrowDices
		ThrowDices(5);
		
		
	}
	//rector code by Emil.
	//Method that throws a specified amount of dices
	public static void ThrowDices(int numberOfDices){
		if(numberOfDices > max_dices){
			throw new IndexOutOfBoundsException();
		}
		else{
			for(int i=0;i<numberOfDices;i++){
				Dice dice = new Dice();
				dice.ThrowDie(min,max);
				diceList.add(dice);
			}
		}
	}
	
	public void showMenu(int choice){
		//TODO Implement menu
	}
	
	public static int menuInput(){
		//TODO Implement menu
		return 0;
	}
}
