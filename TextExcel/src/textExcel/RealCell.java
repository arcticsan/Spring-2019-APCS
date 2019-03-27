package textExcel;

//@author Bryan Chan
//@version March 2019
//SuperClass for all Classes containing double values

public class RealCell implements Cell{
	
	//fields
	private String text;
	
	//constructor
	public RealCell(String input) {
		text = input;
		System.out.println(text);
	}
	
	public String getText() {
		return text;
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(text);
	}
	
	public String fullCellText() {
		return Double.parseDouble(text) + "";
	}
	
	public String abbreviatedCellText() {
		String gridText = Double.parseDouble(text) + "              ";
		return gridText.substring(0,10);
	}
}
