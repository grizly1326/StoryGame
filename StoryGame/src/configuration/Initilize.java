package configuration;

import java.io.File;

import file.ImportFile;

public class Initilize {
	public static void init(){
		Identificators ident= new Identificators();
		ImportFile s= new ImportFile("C:/Users/malyd/workspace/StoryGame/story/story.txt");		//rewrite this to relative not aboslute position.
		s.printText(0);
	}
}
