package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import story.StoryArray;
import configuration.Config;

public class WriteStory {
	static int numberOfBlocks=0;
	static boolean run=true;
	static boolean firstTime=true;
	public static void looper(int index){
		//story telling starts here
		if(firstTime){
			printProgress();																	//import progress of the story.
			//StoryArray.removeBlockInProgress(StoryArray.getProgressSize());
			firstTime=false;
		}											
		while(StoryArray.getListBlock(Config.progress).getType()!=4){							//checks if the story ended.("END").
			if(!run)break;
			chooseBlock(index);
		}
		StoryArray.addToProgress(StoryArray.getListBlock(Config.progress));						//saves progress, to progress Array(end).
		//wana restart the story?
	}
	private static void chooseBlock(int index){
		if(StoryArray.getListBlock(Config.progress+1).getType()==4){							//checks if the story ended.("END").
			Config.progress++;
			looper(Config.progress);															//exits the game, because there is an End, in the Story.
		}
		while(StoryArray.getListBlock(Config.progress).getType()==2){
			StoryArray.addToProgress(StoryArray.getListBlock(Config.progress));					//saves progress, to progress Array(text).
			System.out.println(StoryArray.getListBlock(Config.progress).getText());				//This will be displayed in some-kind of label(GUI).
			printText(Config.progress);																		//GUI Text
			sleep((StoryArray.getListBlock(Config.progress).getText()).length());				//sleeps for how long is the text/2.
			Config.progress++;
			numberOfBlocks++;
			
		}
		if(StoryArray.getListBlock(Config.progress).getType()==1){
			System.out.println(StoryArray.getListBlock(Config.progress).getStringA()+" : "+StoryArray.getListBlock(Config.progress).getStringB());		//delete after creating GUI.
			StoryArray.addToProgress(StoryArray.getListBlock(Config.progress));					//saves progress, to progress Array(splitter).Add this until its not the last thing.
			printSelecting(Config.progress);													//GUI Selecting.
			numberOfBlocks++;
			run=false;
			return;																				//returns to the previous method.
		}
		
	}
	private static void printText(int index){
		JLabel text=new JLabel();
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setVisible(true);
		text.setBounds(10, numberOfBlocks*25, 460, 25);
		text.setText(StoryArray.getListBlock(index).getText());
		Config.frame.add(text);
		Config.frame.repaint();																	//repaints the JFrame.
	}
	private static void printSelecting(int index){
		for(int i=0;i<2;i++){
			JButton select=new JButton();
			if(i==0){
				select.setText(StoryArray.getListBlock(index).getStringA());
				select.setBounds(10, numberOfBlocks*25, 200, 25);
			}else{
				select.setText(StoryArray.getListBlock(index).getStringB());
				select.setBounds(220, numberOfBlocks*25, 200, 25);
			}
			select.setVisible(true);
			Config.frame.add(select);
			select.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				//This decides what have you clicked....and resumes the story.
					if((((JButton)e.getSource()).getText()).equals(StoryArray.getProgressBlock(index).getStringA()))Config.progress=StoryArray.getListBlock(index).getPathA();
					if((((JButton)e.getSource()).getText()).equals(StoryArray.getProgressBlock(index).getStringB()))Config.progress=StoryArray.getListBlock(index).getPathB();
					run=true;
					looper(index);
				}
				
			});
			Config.frame.repaint();
		}
	}
	private static void sleep(int length){
		try {
			Thread.sleep(Config.sleep*100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private static void printProgress(){
		for(int i=0;i<Config.progress;i++){
			if(StoryArray.getListBlock(i+1).getType()==4){							//checks if the story ended.("END").
				i++;
				looper(i);															//exits the game, because there is an End, in the Story.
			}
			while(StoryArray.getListBlock(i).getType()==2){
				System.out.println(StoryArray.getListBlock(i).getText());				//This will be displayed in some-kind of label(GUI).
				printText(i);																		//GUI Text.
				i++;
				numberOfBlocks++;
			}
			if(StoryArray.getListBlock(i).getType()==1){
				System.out.println(StoryArray.getListBlock(i).getStringA()+" : "+StoryArray.getListBlock(i).getStringB());		//delete after creating GUI.
				printSelecting(i);																	//GUI Selecting.
				numberOfBlocks++;
				run=false;
				return;																				//returns to the previous method.
			}
		}
	}
}
