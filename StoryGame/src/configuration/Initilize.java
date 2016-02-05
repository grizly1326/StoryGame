package configuration;

import java.io.File;

import file.ImportFile;

public class Initilize {
	public static void init(){
		Identificators ident= new Identificators();				//fills the array.
		//ident.getArray();
		ImportFile s= new ImportFile("./story/story.txt");		//rewrite this to relative not aboslute position.
		s.importStory();
	}
}
