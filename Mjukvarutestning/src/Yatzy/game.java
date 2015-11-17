package Yatzy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class game {
	//static fields
	public final int min = 1;
	public final int max = 6;
	public final int max_dices = 5;
	public List<Dice> diceList = new ArrayList<Dice>();
	public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	public game(){
		//run();
	}
	
	//start method
	public static void main(String[] args){
		//menuInput();
		//run();
		game g = new game();
		g.run();
		
	}
	
	public Dice GetDiceByNumber(int num){
		
		return diceList.get(num);
		
	}
	//run method for the game
	public void run(){
		int input;
		
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
		PrintResult(5);
	}
	//refactor code by Emil.
	//Method that throws a specified amount of dices
	public void ThrowDices(int numberOfDices){
		
		//System.out.print("hello");
		//System.setOut(new PrintStream(outContent));
		
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
	
	//Method written by Mikael
	public void PrintResult(int num){
		if(diceList.size() != num)
		{
			throw new IndexOutOfBoundsException();
		}
		System.setOut(new PrintStream(outContent));
		for(int i=0;i<diceList.size();i++){
			System.out.print(diceList.get(i).GetValue() + " ");
		}
	}
	
	public void showMenu(int choice){
		//Switch statement
		//System.out.println(choice);
	}
	
	//Code Mikael, Refector Emil & Mikael
	public void menuInput(InputStream in){
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
		    
		    if(choice < 1 || choice > 2)
		    {
		    	throw new IndexOutOfBoundsException("Error! Not in range.");
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
