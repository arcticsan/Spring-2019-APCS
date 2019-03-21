package textExcel;

public class PercentCell extends ValueCell{

	//inherited fields
	//text = will be input with without %
	//value = true double value of input
	
	//Constructor
	public PercentCell(String input) {
		super(input.substring(0, input.charAt('%'))); //Text without '%'
		adjustDoubleValue();
	}
	
	//Re-adjust the decimal to true value 8.93% --> 0.089
	public void adjustDoubleValue () {
		setDoubleValue(Double.parseDouble(getText()) * .01); 
	}
	
	public String abbreviatedCellText() {
		String gridText = getText() + "%              ";
		return gridText.substring(0,10);
	}
	
	//fullCellText same as ValueCell
}
