package display;

import story.StoryArray;

public class WriteStory {
	static int progress;
	public static void looper(int index){
		progress=index;
		//story starts here
		while(!StoryArray.getListBlock(progress).getEnd()){
			chooseBlock();
		}
	}
	private static void chooseBlock(){
		while(!StoryArray.getListBlock(progress).getType()){
			StoryArray.addToProgress(StoryArray.getListBlock(progress));
			//Add here some kind of delay while typing(depends on the length of the text[+-some error...]).
			System.out.println(StoryArray.getListBlock(progress).getText());		//This will be displayed in some-kind of label(GUI).
			progress++;
		}
		System.out.println(StoryArray.getListBlock(progress).getStringA()+" : "+StoryArray.getListBlock(progress).getStringB());
		if(StoryArray.getListBlock(progress).getEnd()){
			looper(progress);						//exits the game, because there is an End, in the Story.
		}else{
			progress++;								//insurance it will exit,here will be the GUI to write out the selection.
			///delete the progress++ after inserting the GUI.
			
		}		
	}
}
