package textExcel;

public class TextCell implements Cell {
	private String text;
	
	//constructor assigns text
	public TextCell(String input) {
		text = input;	
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return text.substring(0,10);	
	}
	
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return text; 		
	}

}
