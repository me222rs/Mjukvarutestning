package tests;
import static org.mockito.Mockito.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
	   public void test_CheckDiceListSize(){
		   game g = new game();
		   g.ThrowDices(5);
		   g.PrintResult(4);
	   }

	   //Testing the dice console output of the PrintResult() method
	   //Test written by Mikael
	   @Test
	   public void test_resultOutput() {
	       game g = new game();
	       Dice d = new Dice();
	       d.ThrowDie(min, max);
	       d.SetValue(1);
	       g.diceList.clear();
	       g.diceList.add(d);
	       g.diceList.add(d);
	       g.diceList.add(d);
	       g.diceList.add(d);
	       g.diceList.add(d);
	       
	       g.PrintResult(5);
	       assertEquals("1 1 1 1 1 ", g.outContent.toString());
	       //Resets the outContent so that nothing will go wrong next time it is used
	       g.outContent.reset();
	       
	   }
	   
	//Test returning a specific dice that should be rethrown
}
