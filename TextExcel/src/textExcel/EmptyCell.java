//Bryan Chan
//March 4,2019

package textExcel;

public class EmptyCell implements Cell{
	
	private String blank;
	
	//constructor
	public EmptyCell() {
		blank = "          ";
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return blank;		
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return blank;		
	}
}
