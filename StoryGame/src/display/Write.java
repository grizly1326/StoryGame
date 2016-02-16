package display;

import story.StoryArray;

public class Write {
	static boolean firstTime=true;
	public static void loop(int index){
		if(firstTime&&(StoryArray.getProgressSize()!=0)){
			importStory(StoryArray.getProgressSize());
			firstTime=false;
		}
		if(StoryArray.getListBlock(index).getType()==4){
			//check if the story ended.
		}
		while(StoryArray.getListBlock(index).getType()!=4){
			//print the story
			selectBlock(index);
		}
	}
	private static void importStory(int index){
		for(int i=0;i<index;i++){
			if(StoryArray.getProgressBlock(i).getType()==2){		//text
				//print text
			}
			if(StoryArray.getProgressBlock(i).getType()==1){
				
			}
		}
	}
	private static void selectBlock(int index){
		
	}
}
