package tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import Yatzy.Controller;
import Yatzy.Dice;
import Yatzy.Model;
import Yatzy.Points;
import Yatzy.View;
import Yatzy.game;

public class MVCtest {
	Model model;
	View view;
	Controller controller;
	
	@Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
		
		//Test by Emil & Mikael
	   @Test(expected=InputMismatchException.class)
	   public void test_MenuChoiceExceptionTest_NotInteger(){
		   ByteArrayInputStream in = new ByteArrayInputStream("t".getBytes());
		   this.view = new View();
		   this.view.MenuChoice(in);
	   }
	   
	   //Test by Emil & Mikael
	   @Test(expected=IndexOutOfBoundsException.class)
	   public void test_MenuChoiceExceptionTest_NotInRange_TooLow(){
		   ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
		   this.view = new View();
		   this.view.MenuChoice(in);
	   }
	   
	   //Test by Emil & Mikael
	   @Test(expected=IndexOutOfBoundsException.class)
	   public void test_MenuChoiceExceptionTest_NotInRange_TooHigh(){
		   ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
		   this.view = new View();
		   this.view.MenuChoice(in);
	   }
	   
	   //Test by Emil & Mikael
	   @Test
	   public void test_ThrowAllDicesWithDifferentValues_Mock(){
		   List<Dice>diceList = new ArrayList<Dice>();
		   String expected = "12345";
		   
		   Dice d1 = mock(Dice.class);
		   when(d1.GetValue()).thenReturn(1);
		   
		   Dice d2 = mock(Dice.class);
		   when(d2.GetValue()).thenReturn(2);
		   
		   Dice d3 = mock(Dice.class);
		   when(d3.GetValue()).thenReturn(3);
		   
		   Dice d4 = mock(Dice.class);
		   when(d4.GetValue()).thenReturn(4);
		   
		   Dice d5 = mock(Dice.class);
		   when(d5.GetValue()).thenReturn(5);
		   
	       diceList.add(d1);
	       diceList.add(d2);
	       diceList.add(d3);
	       diceList.add(d4);
	       diceList.add(d5);
		   Controller c = new Controller(model,view);
		   diceList = c.ThrowAllDice(diceList);
		   String result ="";
		   for(int i = 0; i<diceList.size(); i++)
		   {
			   result += diceList.get(i).GetValue();
		   }
		   
	       assertEquals(result, expected);
	      
	       verify(d1, times(1)).GetValue();
	       verify(d2, times(1)).GetValue();
	       verify(d3, times(1)).GetValue();
	       verify(d4, times(1)).GetValue();
	       verify(d5, times(1)).GetValue();
	   }
	   
	   	@Test
	    public void Test_systemExit() {
		    exit.expectSystemExitWithStatus(0);
			ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
		    this.view = new View();
		    int choice = this.view.MenuChoice(in);
		    this.controller = new Controller(this.model, this.view);
		    this.controller.SwitchChoice(choice);
	    }
}
