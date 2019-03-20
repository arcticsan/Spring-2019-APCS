package textExcel;

public class PercentCell extends ValueCell{

	//Constructor
	public PercentCell(String input) {
		super(input.substring(0, input.charAt('%'))); //Text without '%'
		adjustDoubleValue();
		
	}
	
	//Re-adjust the decimal value
	public void adjustDoubleValue () {
		setDoubleValue(Double.parseDouble(getText()) * .01);
	}
}
