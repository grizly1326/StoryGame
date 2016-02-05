package story;

//----------------------------------------------------------
//switcher=true(is a switcher, to indicate is a switch block)
//switcher=false(is a switcher, to indicate is a text block)
//-----------------------------------------------------------

public class StoryBlock {
	int blockNumber;
	boolean switcher;
	String text;
	int pathA;
	String stringA;
	String stringB;
	int pathB;
	public void addText(String text){
		this.text=text;
	}
	public void addPath(String a, int pathA, String b, int pathB){
		this.pathA=pathA;
		this.pathB=pathB;
		this.stringA=a;
		this.stringB=b;
	}
	public int getBlockNumber(){
		return blockNumber;
	}
	public void setBlockNumber(int number){
		this.blockNumber=number;
	}
	public void setType(boolean type){
		this.switcher=type;
	}
	public boolean getType(){
		return switcher;
	}
	public String getText(){
		return text;
	}
	public String getStringA(){
		return stringA;
	}
	public String getStringB(){
		return stringB;
	}
	public int getPathA(){
		return pathA;
	}
	public int getPathB(){
		return pathB;
	}
}
