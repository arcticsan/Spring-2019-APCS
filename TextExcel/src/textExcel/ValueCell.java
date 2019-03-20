package textExcel;
import java.util.*;

public class ValueCell extends RealCell{

	//constructor
	public ValueCell(String input) {
		super(input);
		double decimalValue = Double.parseDouble(input);
		setDoubleValue(decimalValue);
	}
	
	//Abbreviates text for grid
	public String abbreviatedCellText() {
		String gridText = getText() + "              ";
		return gridText.substring(0,10);
	}

	//Access fullText for inspection
	public String fullCellText() {
		return getText();
	}
	
	public double getDoubleValue() {
		return super.getDoubleValue();
	}
}
