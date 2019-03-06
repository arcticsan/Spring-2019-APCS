// @author Bryan Chan
// @versioin 6 March 2019

package textExcel;
import java.util.*;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int cols;
	
	//Constructor
	//Converts String Location "B6" to Numerical Location Row 5 & Column 1
	public SpreadsheetLocation(String cellName)
    {
		cellName = cellName.toLowerCase();
		String num = cellName.substring(1, cellName.length());
		row = Integer.parseInt(num) -1;
        char letter = cellName.charAt(0);
        cols = letter - 97;      
    }

    @Override
    // gets row of this location
    public int getRow()
    {
        return row;
    }

    @Override
    // gets column of this location
    public int getCol()
    {
        return cols;
    }
}
