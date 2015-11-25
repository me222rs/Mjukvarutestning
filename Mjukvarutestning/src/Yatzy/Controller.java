package Yatzy;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Controller {
	public Model model;
	public View view;
	int min = 1;
	int max = 6;
	List<Dice> diceList = new ArrayList<Dice>();
	
	public Controller (Model model, View view){
		model = new Model();
		view = new View();
		this.model = model;
		this.view = view;
		//Start(this.model, this.view);
	}
	
	public void Start(Model model, View view){
		model = this.model;
		view = this.view;
		view.GetStartMenu();
		ByteArrayInputStream input = view.InputStartMenu();
		int choice = view.MenuChoice(input);
		SwitchChoice(choice);
	}
	
	public List<Dice> ThrowAllDice(List<Dice> diceList){
		this.diceList = diceList;
		if(diceList.isEmpty()){
			for(int i = 0; i < 5;i++){
				Dice dice = new Dice();
				dice.ThrowDie(min,max);
				diceList.add(dice);
			}
		}
		return diceList;
	}
	
	public void SwitchChoice(int choice){
		List<Dice >diceList = new ArrayList<Dice>();
		ByteArrayInputStream rethrow;
		String str;
		List<Dice> diceToBeRethrown;
		switch(choice){
			case 1:
			{
				diceList = ThrowAllDice(diceList);
				view.PrintResult(diceList);
				view.ShowRethrowMenu();
				rethrow = view.InputStartMenu();
				str = view.GetMenuInputAsString(rethrow);
				
				diceToBeRethrown = ShowRethrowMenu(str);
				diceList = RethrowDice(diceToBeRethrown);
				
				view.AfterRethrow();
				view.PrintResult(diceList);
				break;
			}
			case 2:
			{
				break;
			}
			case 3:
			{
				System.exit(0);
				break;
			}
			default:
			{
				break;
			}
		}
	}
	
	public List<Dice> RethrowDice(List<Dice> diceList){
		for(int i = 0; diceList.size() < 5;i++){
			Dice d = new Dice();
			d.ThrowDie(1, 6);
			diceList.add(d);
		}
		System.out.println(diceList.size());
		return diceList;
	}
	
	public int GetListSize()
	{
		return diceList.size();
	}
	
	//Code by Emil & Mikael
	public List<Dice> ShowRethrowMenu(String dicesToRethrow){
		
		
		
		if(!dicesToRethrow.matches("[0-9 ]+")){
			throw new NumberFormatException("Only numbers allowed!");
		}
		
		if(!dicesToRethrow.matches("[0-5 ]+"))
		{
			throw new IllegalArgumentException("Error not in Range of 1-5 input.");
		}
		
		String[] splitted = dicesToRethrow.split("\\s+");
		
	    Integer[] ints = new Integer[splitted.length];
	    for (int i=0; i < splitted.length; i++) {
	        ints[i] = Integer.parseInt(splitted[i]);
	    }
	    
	    Arrays.sort(ints, Collections.reverseOrder());
	    
	    Set<Integer> set = new HashSet<Integer>(Arrays.asList(ints)); 
	    if(set.size() < ints.length )
	    {
	    	throw new IllegalArgumentException("Error!Can't remove the same dice.");
	    }
	    
	    if(ints[0] == 0){
	    	
	    	System.out.print("none");
	    	
	    	
	    	
	    }
	    else{
		    for (int i=0; i < ints.length; i++) {
		        diceList.remove(ints[i] - 1);
		        
		    }
	    }
	    
		return diceList;
		
	}
	
	
}
