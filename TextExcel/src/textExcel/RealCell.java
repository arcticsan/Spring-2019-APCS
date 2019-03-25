package textExcel;

public class RealCell implements Cell{
	
	//fields
	private String text;
	private double value;
	
	//constructor
	public RealCell(String input) {
		text = input;
		System.out.println(text);
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
		value = Double.parseDouble(text);
		return value + "";
	}
	
	public String abbreviatedCellText() {
		value = Double.parseDouble(text);
		String gridText = value + "              ";
		return gridText.substring(0,10);
	}
}
