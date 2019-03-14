package textExcel;

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
			return (cellInspect(command));
		}
		
		//check for clear commands
		else if (command.contains("clear")) {
			if (command.length() <= 5) { // clear sheet
				
			}
			else { // clear cell
				return(clearCell(command.substring(6)));
				
			}
		}
		else {
			String[] arr = command.split(" ");
		
			//check for clear specific cell
			if (arr[0].equals("clear")) {
				Location loca = new SpreadsheetLocation(arr[1]);
			}
			//all other commands that edit cell
			else {
				Location loca = new SpreadsheetLocation(arr[0]);
			}
			
			
		//System.out.println("row: " + loca.getRow());
		//System.out.println("Column: " + loca.getCol());
		}
		return "";
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
		// TODO Auto-generated method stub
		return null;
	}
	
	//clears cell
	public String clearCell(String cellLoca) {
		Location loca = new SpreadsheetLocation(cellLoca);
		sheet[loca.getRow()][loca.getCol()] = new EmptyCell();
		return (getCell(loca).fullCellText());
	}
	
	//cell inspection
	public String cellInspect(String cellLoca) {
		Location loca = new SpreadsheetLocation(cellLoca);
		return (getCell(loca).fullCellText());
	}
	
}
