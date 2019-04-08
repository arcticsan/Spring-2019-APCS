package textExcel;

//@author Bryan Chan
//@version March 2019
//Class for formulas, extends RealCell

public class FormulaCell extends RealCell {
	
	//fields 
	//text = formula with parenthesis (inherited)
	//Spreadsheet sheet;

	//constructor
	public FormulaCell(String input) {
		super(input);
		//sheet = sheetRef;
	}
	
	public String abbreviatedCellText() {
		String gridText = getDoubleValue() + "              ";
		return gridText.substring(0,10);
	}

	
	public String fullCellText() {
		return getText();
	}
	
	//Returns double value of formula
	public double getDoubleValue() {
		String command = getText();
		String[] formula = command.split(" ");
		Double tempValue = Double.parseDouble(formula[1]);//doMath(Double.parseDouble(formula[1]), formula[2], Double.parseDouble(formula[3]));
		for (int i = 1; i < formula.length; i+=2) {
			if (formula[i+1].contentEquals(")") == true) {
				return tempValue;
			}
			tempValue = doMath(tempValue, formula[i+1], Double.parseDouble(formula[i+2]));
		}
		return -999.0;
	}
	
	//Taken from FracCalc
	//Determines operation, does the math, & returns the result
	public double doMath(double operand1, String operator, double operand2) {
		double answer = 0.0;
		if (operator.contentEquals("*") == true) {
        	answer = operand1 * operand2;
        }
        else if (operator.contentEquals("/") == true) {
        	answer = operand1 / operand2;
        }
        else if (operator.contentEquals("+") == true) {
        	answer = operand1 + operand2;
        }
        else if (operator.contentEquals("-") == true) {
        	answer = operand1 - operand2;
        }
		return answer;
	}

}
