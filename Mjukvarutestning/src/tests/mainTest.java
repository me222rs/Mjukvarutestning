package tests;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.junit.Assert.*;
import org.junit.Test;
import Yatzy.Dice;
import Yatzy.game;



public class mainTest {
	//private field with minumum and maximun values allowed
	private static final int min = 1;
	private static final int max = 6;
	
	   @Test
	   //Test by Emil and Mikael.
	   public void test_diceValues() {
		   Dice die = new Dice();
		   die.ThrowDie(min,max);
		   assertTrue(die.GetValue() <= max && die.GetValue() >= min);
	   }
	   
	   //Test written by Mikael
	   //implementing refactor code.
	   //Testing if exception is thrown if more than 5 dices are thrown
	   @Test(expected=IndexOutOfBoundsException.class)
	   public void test_numberOfThrowsExceptionTest_HighValue(){
		   game g = new game();
		   g.ThrowDices(6);
	   }
	
}
