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
	public int numberOfLines(){
		int counter=0;
		try {
			while((br.readLine())!=null) counter++;
		} catch (IOException e) {
			e.printStackTrace();					//cannot read line.
		}
		return counter;
	}
	public void printText(int index){
		String line;
		int counter=0;
		try {
			while((line=br.readLine())!=null){
				if(counter>=index){
					System.out.println(line);
				}
				counter++;
			}
		} catch (IOException e) {
			e.printStackTrace();			//cannot read line.
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();			//cannot close reader.
		}
	}

}
