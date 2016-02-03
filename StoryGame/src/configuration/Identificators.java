package configuration;

import java.util.ArrayList;

public class Identificators {
	public static ArrayList<String> list=new ArrayList<String>(); 			//it has to be static for to be same when its called.
	public Identificators(){
		fill();
	}
	public void fill(){
		//---------------------
		//1=info(pager-like inforamtion,.....).
		//2=split(selects a few parameter in the text that are splited by a special character).
		//3=text(Simple text that has some delay when texting by its length).
		//4=settings(Here is saved curent number of line, [and progression==list of made choices]).
		//---------------------
		list.add("Info");
		list.add("Split");
		list.add("Text");
		list.add("Settings");
	}
}
