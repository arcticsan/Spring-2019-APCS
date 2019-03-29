//Bryan Chan
//March 4,2019
//Class for emptycells

package textExcel;

public class EmptyCell implements Cell{
	
	private String blank;
	private String text;
	
	//constructor
	public EmptyCell() {
		blank = "          ";
		text = "";
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return blank;		
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return text;		
	}
}
