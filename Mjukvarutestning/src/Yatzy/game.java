package Yatzy;

import java.util.ArrayList;
import java.util.List;

public class game {
	public static final int min = 1;
	public static final int max = 6;
	public static List<Dice> diceList = new ArrayList<Dice>();
	
	public static void main(String[] args){
		//menuInput();
		run();
	}
	
	public static void run(){
		ThrowDices(5);
		
		//Call ThrowDices
	}
	
	//Method that throws a specified amount of dices
	public static void ThrowDices(int times){

		for(int i=0;i<times;i++){
			Dice dice = new Dice();
			dice.ThrowDie(min,max);
			diceList.add(dice);
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
