package tests;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
	   
	   @Test(expected=IndexOutOfBoundsException.class)
	   public void test_numberOfThrowsExceptionTest_LowValue(){
		   game g = new game();
		   g.ThrowDices(4);
	   }
	   
	   @Test(expected=InputMismatchException.class)
	   public void test_MenuChoiceExceptionTest_NotInteger(){
		   ByteArrayInputStream in = new ByteArrayInputStream("t".getBytes());
		   game g = new game();
		   g.menuInput(in);
	   }
	   
	   @Test(expected=IndexOutOfBoundsException.class)
	   public void test_MenuChoiceExceptionTest_NotInRange(){
		   ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
		   game g = new game();
		   g.menuInput(in);
	   }
	   
	   @Test(expected=IndexOutOfBoundsException.class)
	   public void test_DiceList_NotInRange(){
		   game g = new game();
		   g.ThrowDices(5);
		   
		   g.PrintResult(4);
		   
		   //assertEquals(g.diceList.size(), 5);
	   }
	
}
