package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import story.StoryArray;
import configuration.Config;
import file.SaveProgress;

public class WriteStory {
	static int numberOfBlocks=0;
	static boolean run=true;
	static boolean firstTime=true;
	public static void looper(){
		//story telling starts here
		System.out.println("NEW STORY-------------------------");
		if(StoryArray.getListBlock(Config.progress).getType()==4){
			System.out.println("Wana restart the program and start over?");
			restart();
			run=false;
		}
		if(firstTime&&run){
			System.out.println("Import STORY.");
			printProgress(StoryArray.getProgressSize());																//import progress of the story.
			firstTime=false;
		}											
		while(StoryArray.getListBlock(Config.progress).getType()!=4){							//checks if the story ended.("END").
			if(!run)break;
			chooseBlock();
			SaveProgress.save();													//add this to every iteration of choosing.
			System.out.println("Game Saved.");										//saves the game at every split, or at the end.
		}
	}
	private static void chooseBlock(){
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
		if(StoryArray.getListBlock(Config.progress).getType()==4){							//checks if the story ended.("END").
			StoryArray.addToProgress(StoryArray.getListBlock(Config.progress));
			restart();
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
					System.out.println("Destination: "+Config.progress);
					looper();
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
	private static void printProgress(int progress){
		for(int i=0;i<progress;i++){
			if(StoryArray.getProgressBlock(i).getType()==4){							//checks if the story ended.("END").
				return;															//exits the game, because there is an End, in the Story.
			}
			if(StoryArray.getProgressBlock(i).getType()==2){							//chceks if its a text.
				System.out.println(StoryArray.getListBlock(i).getText());				//This will be displayed in some-kind of label(GUI).
				printText(i);															//GUI Text
				numberOfBlocks++;
			}
			if(StoryArray.getProgressBlock(i).getType()==1){								//checks if its a split.
				System.out.println(StoryArray.getProgressBlock(i).getStringA()+" : "+StoryArray.getProgressBlock(Config.progress).getStringB());		//delete after creating GUI.
				printSelecting(i);													//GUI Selecting.
				numberOfBlocks++;
				run=false;																			//returns to the previous method.
			}	
		}
	}
	private static void restart(){
		JButton restart=new JButton();
		restart.setHorizontalAlignment(SwingConstants.CENTER);
		restart.setVisible(true);
		restart.setBounds(10, numberOfBlocks*25, 460, 25);
		restart.setText("RESTART");
		Config.frame.add(restart);
		
		restart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
				    Files.delete(Paths.get(Config.nameOfStory+Config.nameOfProgress+".txt"));
				    System.out.println(Paths.get(Config.nameOfStory+Config.nameOfProgress)+": DELETED.");			//make this into GUI Label or something like that.
				} catch (NoSuchFileException x) {
				    System.err.format("%s: no such" + " file or directory%n",Config.nameOfStory+Config.nameOfProgress);
				}catch(IOException e){
					System.out.println("ERROR: "+e);
				}
				//restart button.
				//delete all labels, buttons and reset number of blocks.
				System.exit(0);
				
			}
		});
	}
}
