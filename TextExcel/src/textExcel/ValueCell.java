package textExcel;
import java.util.*;

//@author Bryan Chan
//@version March 2019
//Class for Doubles, extends Realcell

public class ValueCell extends RealCell{
	
	private double value;

	public ValueCell(String input) {
		super(input);
		value = Double.parseDouble(input);
	}
	
	//Inherits & Uses RealCell's abreviatedCellText()
	
	public String fullCellText() {
		return getText();
	}
	
	//Inherits & Uses RealCell's getDoubleValue()
}
