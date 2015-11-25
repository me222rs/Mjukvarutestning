package Yatzy;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
		switch(choice){
			case 1:
			{
				diceList = ThrowAllDice(diceList);
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
	
	public int GetListSize()
	{
		return diceList.size();
	}
	
		//Code by Emil & Mikael
		public int ShowRethrowMenu(String dicesToRethrow){
			
			int msg =0;
			String[] splitted = dicesToRethrow.split("\\s+");
			
		    Integer[] ints = new Integer[splitted.length];
		    for (int i=0; i < splitted.length; i++) {
		        ints[i] = Integer.parseInt(splitted[i]);
		    }
		    
		    Arrays.sort(ints, Collections.reverseOrder());
		   
		    if(ints[0] == 0){
		    	
		    	System.out.print("none");
		    	msg =0;
		    	
		    	
		    }
		    else{
			    for (int i=0; i < ints.length; i++) {
			        diceList.remove(ints[i] - 1);
			        msg++;
			    }
		    }
		    
			return msg;
			
		}
	
	
}
