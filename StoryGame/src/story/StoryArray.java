package story;

import java.util.ArrayList;

public class StoryArray {
	static ArrayList<StoryBlock>list= new ArrayList<StoryBlock>();
	static ArrayList<StoryBlock>progress= new ArrayList<StoryBlock>();		//saves the progress in an Array.
	public static int getProgressSize(){
		return progress.size();
	}
	public static int getListSize(){
		return list.size();
	}
	public static void addToList(StoryBlock block){
		list.add(block);
	}
	public static StoryBlock getListBlock(int index){
		return list.get(index);
	}
	public static void addToProgress(StoryBlock block){
		progress.add(block);
	}
	public static StoryBlock getProgressBlock(int index){
		return progress.get(index);
	}
	public static void removeBlockInList(int index){
		list.remove(index);
	}

}
