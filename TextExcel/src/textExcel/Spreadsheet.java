package textExcel;

import java.util.Arrays;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] sheet;
	private int numRows;
	private int numCols;
	
	//CONSTRUCTOR
	//initializes 2D array of 20rows 12columns
	public Spreadsheet() {
		numRows = 20;
		numCols = 12;
		sheet = new Cell [numRows][numCols];
		for (int row = 0; row < numRows; row++) {
			for(int column = 0; column < numCols; column++) {
				sheet[row][column] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		//check for cell inspection
		if (command.length() <= 3) {
			return cellInspect(command);
		}
		
		//check for clear commands
		else if (command.substring(0,5).equalsIgnoreCase("clear")) {
			if (command.length() <= 5) { // clear sheet
				return clearSheet();
			}
			else { // clear cell
				return clearCell(command.substring(6));
				
			}
		}
		
		//all other actions
		else {
			if (command.indexOf("\"") != -1) { //Check for text assignment
				return assignString(command);
			}
			else {
				String[] arr = command.split(" ",3);
				Location loca = new SpreadsheetLocation(arr[0]);
				if (command.contains("(")) {
					sheet[loca.getRow()][loca.getCol()] = new FormulaCell(arr[2]);
					return getGridText();
				}
				else if (command.contains("%")) {
					sheet[loca.getRow()][loca.getCol()] = new PercentCell(arr[2]);
					return getGridText();
				}
				else {
					sheet[loca.getRow()][loca.getCol()] = new ValueCell(arr[2]);
					return getGridText();
				}
				//return "Something went wrong";
			}
		}
	}

	@Override
	public int getRows()
	{
		return numRows;
	}

	@Override
	public int getCols()
	{
		return numCols;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return (sheet[loc.getRow()][loc.getCol()]);
	}

	@Override
	public String getGridText()
	{
		String grid = "";
		String header = "   ";
		
		//Header
		for (int letter = 'A'; letter <= 'L'; letter++) {
			String column = ("|" + (char) letter + "         ");
			header = header + column;
		}
		header = header + "|";
		grid = grid + header + "\n";
		
		//Grid
		for (int rowIndex = 0; rowIndex < sheet.length; rowIndex++) {
			String gridRow = (rowIndex + 1) + " ";
			if ((rowIndex + 1) <= 9) gridRow = gridRow + " ";
			for (int colIndex = 0; colIndex < sheet[rowIndex].length; colIndex++) {
				gridRow = gridRow + "|" + sheet[rowIndex][colIndex].abbreviatedCellText();
			}
			gridRow = gridRow + "|\n";
			grid = grid + gridRow;
		}
		return grid;
	}
	
	//clears cell & returns grid
	public String clearCell(String cellLoca) {
		Location loca = new SpreadsheetLocation(cellLoca);
		sheet[loca.getRow()][loca.getCol()] = new EmptyCell();
		return getGridText();
	}
	
	//cell inspection & returns fullCellText
	public String cellInspect(String cellLoca) {
		Location loca = new SpreadsheetLocation(cellLoca);
		return getCell(loca).fullCellText();
	}
	
	//clears sheet & returns grid
	public String clearSheet() {
		for (int row = 0; row < numRows; row++) {
			for(int column = 0; column < numCols; column++) {
				sheet[row][column] = new EmptyCell();
			}
		}
		return getGridText();
	}
	
	//assigns Text to a TextCell
	public String assignString(String command) {
		String cellLoca = command.substring(0, command.indexOf(" "));
		String text = command.substring((command.indexOf("\"") + 1), command.lastIndexOf("\""));
		Location loca = new SpreadsheetLocation(cellLoca);
		sheet[loca.getRow()][loca.getCol()] = new TextCell(text);
		return getGridText();
	}
	
	//Traverses array to check existence of certain char - returns a boolean
	public boolean checkArr(String arr[], String letter) {
		for(String temp: arr) {
			if (temp.contentEquals(letter)) {
				return true;
			}
		}
		return false;
	}
}
