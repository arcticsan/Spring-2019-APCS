package textExcel;

public class PercentCell extends RealCell{

	//inherited fields
	//text = will be input with with %
	//value = true double value of input
	
	//Constructor
	public PercentCell(String input) {
		super(input);
		adjustDoubleValue(input);
	}
	
	//Re-adjust the decimal to true value ex: 8.93% --> 0.089
	public void adjustDoubleValue (String input) {
		String temp = input.substring(0, input.indexOf("%"));
		setDoubleValue(Double.parseDouble(temp) * .01); 
	}
	
	public String abbreviatedCellText() {
		String gridText = getText() + "          ";
		return gridText.substring(0,10);
	}
	
	public String fullCellText() {
		return getDoubleValue() + "";
	}
}
