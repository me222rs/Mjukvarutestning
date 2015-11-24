package tests;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import org.junit.Test;

import Yatzy.Controller;
import Yatzy.Model;
import Yatzy.View;
import Yatzy.game;

public class MVCtest {
	Model model;
	View view;
	
	   @Test(expected=InputMismatchException.class)
	   public void test_MenuChoiceExceptionTest_NotInteger(){
		   ByteArrayInputStream in = new ByteArrayInputStream("t".getBytes());
		   this.view = new View();
		   this.view.MenuChoice(in);
	   }
	   
	   @Test(expected=IndexOutOfBoundsException.class)
	   public void test_MenuChoiceExceptionTest_NotInRange_TooLow(){
		   ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
		   this.view = new View();
		   this.view.MenuChoice(in);
	   }
	   
	   @Test(expected=IndexOutOfBoundsException.class)
	   public void test_MenuChoiceExceptionTest_NotInRange_TooHigh(){
		   ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
		   this.view = new View();
		   this.view.MenuChoice(in);
	   }
}
