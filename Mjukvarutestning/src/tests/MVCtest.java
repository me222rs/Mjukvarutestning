package tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
		List<Dice> diceList = new ArrayList<Dice>();
		public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
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
	   
	   	//Test by Emil & Mikael
	   	@Test
	    public void Test_SystemExit_Menu() {
		    exit.expectSystemExitWithStatus(0);
			ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
		    this.view = new View();
		    int choice = this.view.MenuChoice(in);
		    this.controller = new Controller(this.model, this.view);
		    this.controller.SwitchChoice(choice);
	    }
	   	
	   //Test by Emil & Mikael
	   @Test
	   public void test_ThrowAllDicesResultOutput() {
	   	   List<Dice>diceList = new ArrayList<Dice>();
		   String expected = "1 2 3 4 5";
		   
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
	       
	       this.view = new View();
	       System.setOut(new PrintStream(outContent));
	       this.view.PrintResult(diceList);
	       
	       assertEquals(expected, outContent.toString());		       
	   }
	   	
   	   //Test by Emil & Mikael
   	   @Test
	   public void test_CheckDiceListSize(){
	   		int expected = 5;
	   		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		    this.view = new View();
		    int choice = this.view.MenuChoice(in);
		    this.controller = new Controller(this.model, this.view);
		    
		    controller.ThrowAllDice(diceList);   
			int result = controller.GetListSize();
			assertEquals(expected, result);
	   }
   	   //Test by Emil & Mikael
   	   @Test
	   public void Test_RemoveDieFromList_ToBeRethrown(){
		   
		   	  ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
			  view = new View();
		   	  controller = new Controller(this.model, this.view);
			  
			  controller.ThrowAllDice(diceList);
			  controller.ShowRethrowMenu("3"); 
			  assertEquals(controller.GetListSize(), 4);
	   }
   	   //Test by Emil & Mikael
   	   @Test(expected=IllegalArgumentException.class)
	   public void Test_RemoveDieFromList_ToBeRethrown_OneDie_OneOutOfRange(){
		   
   		 
		  view = new View();

	   	  controller = new Controller(this.model, this.view);

		  controller.ThrowAllDice(diceList);
		  controller.ShowRethrowMenu("7"); 
		  
	   }
	   //Test by Emil & Mikael  
	   @Test
	   public void Test_RemoveDicesFromList_3ToBeRethrown(){
			  view = new View();
		   	  controller = new Controller(this.model, this.view);

			  controller.ThrowAllDice(diceList);
			  controller.ShowRethrowMenu("3 4 5"); 
			  assertEquals(controller.GetListSize(), 2);
	   	 }
		   	 
	   	 //Test by Emil & Mikael
	   	 @Test
	   	 public void Test_RemoveDicesFromList_AllToBeRethrown(){
		   
		   	  ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
			  view = new View();
			  int choice = view.MenuChoice(in);
		   	  controller = new Controller(this.model, this.view);
		   	  controller.ThrowAllDice(diceList);
			  
	       
			  controller.ShowRethrowMenu("3 4 5 2 1"); 
			  assertEquals(controller.GetListSize(), 0);
	   	 }
	   	 
	     //Test by Emil & Mikael
	   	 @Test(expected=IllegalArgumentException.class)
	   	 public void Test_RemoveDuplicatedFromList_ToBeRethrown(){
		   
			  view = new View();
		   	  controller = new Controller(this.model, this.view);

			  controller.ThrowAllDice(diceList);
			  controller.ShowRethrowMenu("1 1"); 
			 
	   	 }
	   	 
	     //Test by Emil & Mikael
	   	 @Test
	   	 public void Test_RethrowDice_OneDie_SizeIs5(){
		   	  List<Dice>diceList = new ArrayList<Dice>();
		   	  List<Dice> temp = new ArrayList<Dice>();
			  view = new View();

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
		      controller = new Controller(this.model, this.view);
			  controller.ThrowAllDice(diceList);
			  temp = controller.ShowRethrowMenu("1");
			  diceList = controller.RethrowDice(temp);
  
			  assertEquals(5, temp.size());
	   	 }
	   	@Test (expected = IndexOutOfBoundsException.class)
	   	public void Test_ThrowDie_highestValue(){
	   		Dice d = new Dice();
	   		d.ThrowDie(1, 7);
	   	}
	   	
	   	@Test (expected = IndexOutOfBoundsException.class)
	   	public void Test_ThrowDie_minimumValue(){
	   		Dice d = new Dice();
	   		d.ThrowDie(0, 6);
	   	}
	   	@Test
	   	public void Test_ShowRethrowMenu_View_Output(){
   		   String expected = "\nWhich dice would you like to rethrow? Separate dice positions with a space.\n";
	       this.view = new View();
	       System.setOut(new PrintStream(outContent));
	       this.view.ShowRethrowMenu();
	       assertEquals(expected, outContent.toString());	
	   	}
	   	
	   	@Test
	   	public void Test_AfterRethrow_View_Output(){
   		   String expected = "\nThis is your dices after they were rethrown.\n";
	       this.view = new View();
	       System.setOut(new PrintStream(outContent));
	       this.view.AfterRethrow();
	       assertEquals(expected, outContent.toString());	
	   	}
	   	
	   	
	   	 @Test (expected = IndexOutOfBoundsException.class)
	   	 public void Test_RegexRethrow(){
		   
		   	  ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
			  view = new View();
		   	  controller = new Controller(this.model, this.view);
		   	  controller.ThrowAllDice(diceList);

			  controller.ShowRethrowMenu("1 7"); 
	   	 }
	   	

}
