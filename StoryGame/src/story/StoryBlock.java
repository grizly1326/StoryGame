package story;

//===========================================================
//type=true(is a type, to indicate is a switch block)
//type=false(is a type, to indicate is a text block)
//===========================================================
//-------------Text(//Info//Text is here.)------------------------------------------
//-addText
//-setType
//-----------Splitter(//Split//TextA/-/pathA/-/TextB/-/pathB)-----------------------
//-addPath
//-setType
//----------End(//End//)------------------------------------------------------------
//-setEnd
//===========================================================
public class StoryBlock {
	int type;
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
	public void setType(int type){
		this.type=type;
	}
	public int getType(){
		return type;
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
