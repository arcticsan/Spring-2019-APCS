package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int rows;
	private int cols;
	
	//CONSTRUCTOR
	//initializes 2D array of 20rows 12columns
	public Spreadsheet() {
		rows = 20;
		cols = 12;
		Cell sheet [][] = new Cell [rows][cols];
	}
	@Override
	public String processCommand(String command)
	{
		return "";
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return cols;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
