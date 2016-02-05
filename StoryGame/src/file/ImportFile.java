package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImportFile {
	int numberOfLines;
	BufferedReader br=null;
	public ImportFile(String nameOfFile){
		loadStory(nameOfFile);
	}
	//Default numberOfLine is 0, at the start of the game.
	public void loadStory(String nameOfFile){
		try {
			FileInputStream fs= new FileInputStream(nameOfFile);
			br = new BufferedReader(new InputStreamReader(fs));
		} catch (FileNotFoundException e) {
			e.printStackTrace();			//cannot make a BufferedReader on this file. /ERROR/
		}
	}
	public void importStory(){
		String line;
		try {
			while((line=br.readLine())!=null){
				//System.out.println(counter+", A:"+line);
				Switching.switcher(line);
			}
		} catch (IOException e) {
			e.printStackTrace();					//cannot read line.
		}
	}

}
