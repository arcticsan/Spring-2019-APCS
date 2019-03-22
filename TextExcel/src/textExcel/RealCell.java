package textExcel;

public class RealCell implements Cell{
	
	//fields
	private String text;
	private double value;
	
	//constructor
	public RealCell(String input) {
		text = input;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String newText) {
		text = newText;
		
	}
	
	public double getDoubleValue() {
		return value;
	}
	
	public void setDoubleValue(double doubleValue) {
		value = doubleValue;
	}

	public String fullCellText() {
		return text;
	}
	
	public String abbreviatedCellText() {
		String gridText = text + "              ";
		return gridText.substring(0,10);
	}
}
