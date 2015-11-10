package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import Yatzy.Dice;
import Yatzy.game;



public class mainTest {
	//private field with minumum and maximun values allowed
	private static final int min = 1;
	private static final int max = 6;
	
	   @Test
	   public void test_diceValues() {
		   Dice die = new Dice();
		   die.ThrowDie(min,max);
		   assertTrue(die.GetValue() <= max && die.GetValue() >= min);
	   }
	
}
