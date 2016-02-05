package file;

import configuration.Identificators;

public class Switching {
	public static void switcher(String s){
		String[]split=s.split("//");
		if(Identificators.list.get(0).equals(split[1])){
			//info block
			printText(split[2]);
		}
		if(Identificators.list.get(1).equals(split[1])){
			//split
		}
		if(Identificators.list.get(2).equals(split[1])){
			//text
		}
		if(Identificators.list.get(3).equals(split[1])){
			//settings
		}
	}
	private static void printText(String print){
		System.out.println(print);
	}
}
