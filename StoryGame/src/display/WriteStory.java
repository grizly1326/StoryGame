package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import story.StoryArray;
import configuration.Config;

public class WriteStory {
	static boolean run=true;
	public static void looper(int index){
		System.out.println("Start");
		//story starts here
		while(StoryArray.getListBlock(Config.progress).getType()!=4){				//checks if the story ended.("END").
			if(!run)break;
			chooseBlock(index);
		}
		StoryArray.addToProgress(StoryArray.getListBlock(Config.progress));			//saves progress, to progress Array(end).
		//wana restart the story?
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
			printText();				//GUI Text
			//sleep((StoryArray.getListBlock(Config.progress).getText()).length());			//sleeps for how long is the text/2.
			Config.progress++;
			
		}
		if(StoryArray.getListBlock(Config.progress).getType()==1){
			System.out.println(StoryArray.getListBlock(Config.progress).getStringA()+" : "+StoryArray.getListBlock(Config.progress).getStringB());		//delete after creating GUI.
			StoryArray.addToProgress(StoryArray.getListBlock(Config.progress));			//saves progress, to progress Array(splitter).
				//progress++;								//insurance it will exit,here will be the GUI to write out the selection.
				///delete the progress++ after inserting the GUI.
			printSelecting();					//GUI Selecting.
			run=false;
			return;			//returns to the previous method.
		}
		
	}
	private static void printText(){
		JLabel text=new JLabel();
		text.setVisible(true);
		text.setBounds(10, Config.progress*25, 200, 50);
		text.setText(StoryArray.getListBlock(Config.progress).getText());
		Config.frame.add(text);
	}
	private static void printSelecting(){
		for(int i=0;i<2;i++){
			JButton select=new JButton();
			if(i==0){
				select.setText(StoryArray.getListBlock(Config.progress).getStringA());
				select.setBounds(10, Config.progress*50, 200, 25);
			}else{
				select.setText(StoryArray.getListBlock(Config.progress).getStringB());
				select.setBounds(220, Config.progress*50, 200, 25);
			}
			select.setVisible(true);
			Config.frame.add(select);
			select.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				//This decides what have you clicked....and resumes the story.
					if((((JButton)e.getSource()).getText()).equals(StoryArray.getProgressBlock(Config.progress).getStringA()))Config.progress=StoryArray.getListBlock(Config.progress).getPathA();
					if((((JButton)e.getSource()).getText()).equals(StoryArray.getProgressBlock(Config.progress).getStringB()))Config.progress=StoryArray.getListBlock(Config.progress).getPathB();
					run=true;
					looper(Config.progress);
					
				}
				
			});
		}
	}
	private static void sleep(int length){
		try {
			Thread.sleep(length*100);				//Length might by set up in configuration file(future updates).
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
