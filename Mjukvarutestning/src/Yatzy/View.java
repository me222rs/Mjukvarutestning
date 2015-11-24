package Yatzy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
	
	public void GetStartMenu(){
		System.out.println("----Menu----");
		System.out.println("1 - Play");
		System.out.println("2 - Results");
	}
	
	public ByteArrayInputStream InputStartMenu(){
		int input;
		Scanner scanner = new Scanner(System.in);
     	input = scanner.nextInt();
     	
     	StringBuilder sb = new StringBuilder();
     	sb.append("");
     	sb.append(input);
     	String inputString = sb.toString();
     	
     	ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
     	return in;
	}
	public int MenuChoice(ByteArrayInputStream in)
	{
		int choice = 0;
		String choiceAsString = "";
		
		//BufferedReader is used so that we can test the menu input
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF8")) ) {
			choiceAsString = reader.readLine();
			
			if(!choiceAsString.matches("-?\\d+(\\.\\d+)?")){
				throw new InputMismatchException("Error! Only integers allowed.");
			}
			
		    choice = Integer.parseInt(choiceAsString);
		    
		    if(choice > 3 || choice < 1 )
		    {
		    	throw new IndexOutOfBoundsException("Error! Not in range.");
		    }
		     
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return choice;
		
	}
}