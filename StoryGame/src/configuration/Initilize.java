package configuration;


import file.ImportFile;

public class Initilize {
	public static void init(){
		Identificators ident= new Identificators();								//fills the array.
		try{
			ImportFile progress= new ImportFile(Config.nameOfStory+Config.nameOfProgress+".txt");			
			progress.importStory();												//imports the Progress to ProgressArray
		}catch(Exception e){
			System.out.println("There isnt any progress");						//add some debug in GUI.
		}
		ImportFile story= new ImportFile(Config.nameOfStory+".txt");
		story.importStory();
	}
}
