// @author Bryan Chan
// @versioin 6 March 2019
// Client Code

package textExcel;
import java.util.*;

import java.io.FileNotFoundException;
import java.util.Scanner;



public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
    	System.out.print("Welcome to TextExcel\nPlease enter a command or type \"quit\" to exit TextExcel: ");
    	String command = userInput.nextLine();
    	Spreadsheet sheet = new Spreadsheet();
    	while (command.equalsIgnoreCase("quit") == false) {
    		//Location loca = new SpreadsheetLocation(command);
    		//System.out.println("row: " + loca.getRow());
    		//System.out.println("Column: " + loca.getCol());
    		//System.out.println(sheet.processCommand(command));
    		System.out.print("Please enter a command or type \"quit\" to exit Frac Calc: ");
    		command = userInput.nextLine();
    	}
	}
}
