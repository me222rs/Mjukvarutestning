package Yatzy;

public class game {
	public static final int min = 1;
	public static final int max = 6;
	
	public static void main(String[] args){
		run();
	}
	
	public static void run(){
		Dice dice = new Dice();
		dice.ThrowDie(min,max);
	}
}
