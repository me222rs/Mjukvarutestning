package Yatzy;

import java.util.List;

public class Model {
	public String CalculatePoints(List<Dice> diceList){
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		String msg = "";
		for(int i = 0; i< diceList.size();i++){
			if(diceList.get(i).GetValue()== 1){
				one++;
			}
			if(diceList.get(i).GetValue()== 2){
				two++;
			}
			if(diceList.get(i).GetValue()== 3){
				three++;
			}
			if(diceList.get(i).GetValue()== 4){
				four++;
			}
			if(diceList.get(i).GetValue()== 5){
				five++;
			}
			if(diceList.get(i).GetValue()== 6){
				six++;
			}
			
		}
		
		if(one == 5 || two == 5 || three == 5 || four == 5 || five == 5 || six == 5){
			msg = "Yatzy (50 points)";
			return msg;
		}
		
		
		return "test";
		
	}
}
