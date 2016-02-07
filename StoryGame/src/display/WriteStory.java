package display;

import configuration.Config;
import story.StoryArray;

public class WriteStory {
	public static void looper(int index){

		//story starts here
		while(StoryArray.getListBlock(Config.progress).getType()!=4){				//checks if the story ended.("END").
			chooseBlock(index);
		}
		StoryArray.addToProgress(StoryArray.getListBlock(Config.progress));			//saves progress, to progress Array(end).
	}
	private static void chooseBlock(int index){
		if(StoryArray.getListBlock(Config.progress+1).getType()==4){				//checks if the story ended.("END").
			Config.progress++;
			looper(Config.progress);						//exits the game, because there is an End, in the Story.
		}
		while(StoryArray.getListBlock(Config.progress).getType()==2){
			StoryArray.addToProgress(StoryArray.getListBlock(Config.progress));			//saves progress, to progress Array(text).
			//Add here some kind of delay while typing(depends on the length of the text[+-some error...]).
			System.out.println(StoryArray.getListBlock(Config.progress).getText());		//This will be displayed in some-kind of label(GUI).
			Config.progress++;
			
		}
		if(StoryArray.getListBlock(Config.progress).getType()==1){
			System.out.println(StoryArray.getListBlock(Config.progress).getStringA()+" : "+StoryArray.getListBlock(Config.progress).getStringB());		//delete after creating GUI.
			StoryArray.addToProgress(StoryArray.getListBlock(Config.progress));			//saves progress, to progress Array(splitter).
				//progress++;								//insurance it will exit,here will be the GUI to write out the selection.
				///delete the progress++ after inserting the GUI.
		}
		
	}
}
