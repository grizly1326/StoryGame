package file;

import configuration.Config;
import configuration.Identificators;
import story.StoryArray;
import story.StoryBlock;
//==================================================
//split[1]=selector(info,Split,Text,End,....)
//split[2]=text it self;
//==================================================
public class Switching {
	public static void switcher(Boolean progress, String s){
		if(progress){
			progress(s);
		}else{
			list(s);
		}
	}
	private static void list(String s){
		String[]split=s.split("//");
		if(Identificators.list.get(0).equals(split[1])){
			//info block
			StoryBlock block=new StoryBlock();
			block.setType(2);			//sets to a text block.
			block.addText(split[2]);
			StoryArray.addToList(block);
		}
		if(Identificators.list.get(1).equals(split[1])){
			String[]splitSelection=split[2].split("/-/");
			//split
			StoryBlock block=new StoryBlock();
			block.setType(1);
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
			block.setType(4);
			StoryArray.addToList(block);
		}
	}
	private static void progress(String s){
		String[]split=s.split("//");
		if(Identificators.list.get(3).equals(split[1])){
			String[]settingsSelection=split[2].split("=");
			if(settingsSelection[0].equals("progress")){
				Config.progress=Integer.parseInt(settingsSelection[1]);
			}
		}
		if(Identificators.list.get(0).equals(split[1])){
			//info block
			StoryBlock block=new StoryBlock();
			block.setType(2);			//sets to a text block.
			block.addText(split[2]);
			StoryArray.addToProgress(block);
		}
		if(Identificators.list.get(1).equals(split[1])){
			String[]splitSelection=split[2].split("/-/");
			//split
			StoryBlock block=new StoryBlock();
			block.setType(1);
			block.addPath(splitSelection[0], Integer.parseInt(splitSelection[1]), splitSelection[2], Integer.parseInt(splitSelection[3]));
			StoryArray.addToProgress(block);
			
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
			block.setType(4);
			StoryArray.addToProgress(block);
		}
	}
}
