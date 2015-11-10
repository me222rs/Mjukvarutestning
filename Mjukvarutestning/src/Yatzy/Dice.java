package Yatzy;

import java.util.Random;

public class Dice {
	private int value;
	private Random random;
	
	public Dice(){
		value = 0;
		random = new Random();
	}
	
	public void ThrowDie(int min, int max){
		value = random.nextInt((min - max) + 1) + min;
	}
	
	public int GetValue(){
		return value;
	}

}
