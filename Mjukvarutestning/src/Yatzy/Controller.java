package Yatzy;

import java.io.ByteArrayInputStream;

public class Controller {
	public Model model;
	public View view;
	
	public Controller (Model model, View view){
		model = new Model();
		view = new View();
		this.model = model;
		this.view = view;
		Start(this.model, this.view);
	}
	
	public void Start(Model model, View view){
		view.GetStartMenu();
		ByteArrayInputStream input = view.InputStartMenu();
		int choice = view.MenuChoice(input);
		
		switch(choice){
			case 1:
			case 2:
			case 3:
			default:
		}
	}
}
