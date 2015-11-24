package Yatzy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Points {
	public List<Dice> diceList;
	
	public Points(game g){
		diceList =  new ArrayList<Dice>();
	}
	
	public String GetResult(List<Dice> list){
		diceList = list;
		String ret = "fjant";
//		for(int i=0; i<diceList.size();i++){
//			if((Collections.frequency(diceList, diceList.get(i))) > 1){
//				ret = "par";
//			}
//		}
		
		Dice tempVal = null;
	    for (int i = 0; i < diceList.size(); i++) {
	        tempVal = diceList.get(i); //take the ith object out of list
	        while (diceList.contains(tempVal)) {
	        	diceList.remove(tempVal); //remove all matching entries
	        }
	        diceList.add(tempVal); //at last add one entry
	        if(diceList.size()> 0){
	        	ret = "par";
	        }
	    }

		System.out.println(ret);
		return ret;
	}
	
	public String testMethod(String str){
		if(str == "1"){
			return "inif";
		}
		else{
			return "outif";
		}
	}
}
