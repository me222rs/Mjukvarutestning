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
		if(max != 6){	
			throw new IndexOutOfBoundsException("To high max value. Must be 6.");	
		}
		value = random.nextInt((max - min) + 1) + min;
		
	}
	
	public int GetValue(){
		return value;
	}
	
	public void SetValue(int num){
		value = num;
	}

}
