package display;

import story.StoryArray;

public class WriteStory {
	static int progress;
	public static void looper(int index){
		progress=index;
		//story starts here
		while(StoryArray.getListBlock(progress).getType()!=4){
			chooseBlock();
		}
	}
	private static void chooseBlock(){
		if(StoryArray.getListBlock(progress+1).getType()==4){
			progress++;
			StoryArray.addToProgress(StoryArray.getListBlock(progress));			//saves progress, to progress Array(end).
			looper(progress);						//exits the game, because there is an End, in the Story.
		}
		while(StoryArray.getListBlock(progress).getType()==2){
			StoryArray.addToProgress(StoryArray.getListBlock(progress));			//saves progress, to progress Array(text).
			//Add here some kind of delay while typing(depends on the length of the text[+-some error...]).
			System.out.println(StoryArray.getListBlock(progress).getText());		//This will be displayed in some-kind of label(GUI).
			progress++;
			
		}
		if(StoryArray.getListBlock(progress).getType()==1){
			System.out.println(StoryArray.getListBlock(progress).getStringA()+" : "+StoryArray.getListBlock(progress).getStringB());		//delete after creating GUI.
			StoryArray.addToProgress(StoryArray.getListBlock(progress));			//saves progress, to progress Array(splitter).
				//progress++;								//insurance it will exit,here will be the GUI to write out the selection.
				///delete the progress++ after inserting the GUI.
		}
		
	}
}
