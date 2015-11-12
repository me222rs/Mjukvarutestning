package Yatzy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class game {
	//static fields
	public static final int min = 1;
	public static final int max = 6;
	public static final int max_dices = 5;
	public static List<Dice> diceList = new ArrayList<Dice>();
	
	//start method
	public static void main(String[] args){
		//menuInput();
		run();
	}
	//run method for the game
	public static void run(){
		int input;
		//Call ThrowDice
		//Menu
		System.out.println("----Menu----");
		System.out.println("1 - Play");
		System.out.println("2 - Results");
		
		Scanner scanner = new Scanner(System.in);
     	input = scanner.nextInt();
     	
     	StringBuilder sb = new StringBuilder();
     	sb.append("");
     	sb.append(input);
     	String inputString = sb.toString();
     	
     	ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
		menuInput(in);
		
		ThrowDices(max_dices);
		
		
	}
	//rector code by Emil.
	//Method that throws a specified amount of dices
	public static void ThrowDices(int numberOfDices){
		if(numberOfDices > max_dices ){
			throw new IndexOutOfBoundsException("Error! Can't be more than 5 dices.");
		}
		//Code and test by Emil.
		else if(numberOfDices < max_dices){
			throw new IndexOutOfBoundsException("Error! Can't be less than 5 dices.");
		}
		else{
			for(int i=0;i<numberOfDices;i++){
				Dice dice = new Dice();
				dice.ThrowDie(min,max);
				diceList.add(dice);
			}
		}
	}
	
	public static void showMenu(int choice){
		//Switch statement
		System.out.println(choice);
	}
	
	//Code Mikael, Refector Emil & Mikael
	public static void menuInput(InputStream in){
		//Read menu input

		int choice = 0;
		String choiceAsString = "";
		
		//BufferedReader is used so that we can test the menu input
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF8")) ) {
			choiceAsString = reader.readLine();
			if(!choiceAsString.matches("-?\\d+(\\.\\d+)?")){
				throw new InputMismatchException("Error! Only integers allowed.");
			}
		    choice = Integer.parseInt(choiceAsString);
		    
		    if(choice > 1)
		    {
		    	throw new IndexOutOfBoundsException();
		    }
		    
		    
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		showMenu(choice);
	}
}
