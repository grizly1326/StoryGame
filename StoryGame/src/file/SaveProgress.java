package file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import configuration.Config;
import story.StoryArray;

public class SaveProgress {
	//save the Progress Array in a file...that will check every time it starts(exists or not).
	public static void save(){
		PrintWriter out=null;
		try {
			out = new PrintWriter("./story/storyProgress.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();			//cannot create a save file.
		}
		//insert save settings here.
		saveSettings(out);
		//=========================
		for(int i=0;i<StoryArray.getProgressSize();i++){
			if(StoryArray.getProgressBlock(i).getType()==4){
				//END
				out.println("//END//");
			}
			if(StoryArray.getProgressBlock(i).getType()==2){
				//text
				out.println("//Info//"+StoryArray.getProgressBlock(i).getText());
			}
			if(StoryArray.getProgressBlock(i).getType()==1){
				//split
				out.println("//Split//"+StoryArray.getProgressBlock(i).getStringA()+"/-/"+StoryArray.getProgressBlock(i).getPathA()+"/-/"+StoryArray.getProgressBlock(i).getStringB()+"/-/"+StoryArray.getProgressBlock(i).getPathB());
			}
		}
		out.close();
	}
	private static void saveSettings(PrintWriter out){
		out.println("//Settings//progress="+Config.progress);
	}
}
