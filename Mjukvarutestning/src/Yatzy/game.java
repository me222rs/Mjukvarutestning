package Yatzy;

public class game {
	public static void main(String[] args){
		run();
	}
	
	public static void run(){
		Dice dice = new Dice();
		dice.ThrowDie(1,6);
	}
}
