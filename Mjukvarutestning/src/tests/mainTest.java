package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import Yatzy.Dice;
import Yatzy.game;

public class mainTest {
	   @Test
	   public void test_init() {
		   Dice die = new Dice();
		   die.ThrowDie(7,12);
		   assertTrue(die.GetValue() <= 6 && die.GetValue() >= 1);
	   }
	
}
