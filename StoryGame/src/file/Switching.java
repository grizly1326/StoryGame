package file;

import configuration.Identificators;
import story.StoryArray;
import story.StoryBlock;
//==================================================
//split[1]=selector(info,Split,Text,End,....)
//split[2]=text it self;
//==================================================
public class Switching {
	public static void switcher(String s){
		String[]split=s.split("//");
		if(Identificators.list.get(0).equals(split[1])){
			//info block
			StoryBlock block=new StoryBlock();
			block.setType(false);			//sets to a text block.
			block.addText(split[2]);
			StoryArray.addToList(block);
		}
		if(Identificators.list.get(1).equals(split[1])){
			String[]splitSelection=split[2].split("/-/");
			//split
			StoryBlock block=new StoryBlock();
			block.setType(true);
			block.addPath(splitSelection[0], Integer.parseInt(splitSelection[1]), splitSelection[2], Integer.parseInt(splitSelection[3]));
			StoryArray.addToList(block);
			
		}
		if(Identificators.list.get(2).equals(split[1])){
			//text
		}
		if(Identificators.list.get(3).equals(split[1])){
			//settings
		}
		if(Identificators.list.get(4).equals(split[1])){
			//End
			StoryBlock block= new StoryBlock();
			block.setEnd(true);
			StoryArray.addToList(block);
		}
	}
}
