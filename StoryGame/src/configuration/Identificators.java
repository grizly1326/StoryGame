package configuration;

import java.util.ArrayList;

//=========================================================================================
//0=info(pager-like inforamtion,.....).
//1=split(selects a few parameter in the text that are splited by a special character).
//2=text(Simple text that has some delay when texting by its length).
//3=settings(Here is saved curent number of line, [and progression==list of made choices]).
//4=End(This represents if the story ended).
//=========================================================================================

public class Identificators {
	public static ArrayList<String> list=new ArrayList<String>(); 			//it has to be static for to be same when its called.
	public Identificators(){
		fill();
	}
	private void fill(){
		list.add("Info");
		list.add("Split");
		list.add("Text");
		list.add("Settings");
		list.add("End");
	}
	public void printArray(){
		for(String a:list){
			System.out.println(a);
		}
	}
}
