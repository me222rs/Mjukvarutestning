package Yatzy;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class Controller {
	public Model model;
	public View view;
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
	}
	
	public List<Dice> ThrowAllDice(List<Dice> diceList){
		return null;
	}
	
	public void SwitchChoice(int choice){
		
	}

}
