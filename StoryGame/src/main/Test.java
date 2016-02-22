package main;


import configuration.Config;
import configuration.Initilize;
import display.WriteStory;
import file.SaveProgress;

public class Test {

	public static void main(String[] args) {
		Initilize.init();														//imports the whole story to an Array.
		createPanel();
		WriteStory.looper();										//the "0" will be replaced with number of line in the ProgressArray.
	}
	private static void createPanel(){
		Config.frame.setBounds(100, 100, 500, 500);
		Config.frame.setLayout(null);
		Config.frame.setDefaultCloseOperation(Config.frame.EXIT_ON_CLOSE);
		Config.frame.setVisible(true);
	}
}
