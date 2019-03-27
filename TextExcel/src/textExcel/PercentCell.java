package textExcel;

//@author Bryan Chan
//@version March 2019
//Class for Percents, extends Realcell

public class PercentCell extends RealCell{

	//inherited field:
	//text = will be input with with %
	
	private double decimalValue; //value of input in decimal form
	
	//Constructor & Assigns decimalValue ex: 8.93% --> 0.089 
	public PercentCell(String input) {
		super(input);
		String temp = input.substring(0, input.indexOf("%"));
		decimalValue = Double.parseDouble(temp) * .01;
	}
	
	//Returns String of truncated percentage value
	public String abbreviatedCellText() {
		String gridText = getText();
		if (gridText.contains(".")) {
			gridText = gridText.substring(0,gridText.indexOf(".")) + "%";
		}
		gridText = gridText + "          ";
		return gridText.substring(0,10);
	}
	
	public String fullCellText() {
		return getDoubleValue() + "";
	}
	
	public double getDoubleValue() {
		return decimalValue;
	}
}
