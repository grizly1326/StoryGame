package main;

import configuration.Initilize;
import display.WriteStory;
import story.StoryArray;
import story.StoryBlock;

public class Test {

	public static void main(String[] args) {
		Initilize.init();											//imports the whole story to an Array. And 
		WriteStory.looper(0);										//the "0" will be replaced with number of line in the ProgressArray.
		System.out.println("Game Over.");
	}

}
