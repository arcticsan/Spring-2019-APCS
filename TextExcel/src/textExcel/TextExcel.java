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
		TestsALL.Helper th = new TestsALL.Helper();
		//System.out.println(th.getText());
		
		Scanner userInput = new Scanner(System.in);
    	System.out.print("Welcome to TextExcel\nPlease enter a command or type \"quit\" to exit TextExcel: ");
    	String command = userInput.nextLine();
    	Spreadsheet sheet = new Spreadsheet();
    	//System.out.println("\n" + sheet.getGridText());
    	while (command.equalsIgnoreCase("quit") == false) {
    		System.out.println("\n" + sheet.processCommand(command));
    		System.out.print("\nPlease enter a command or type \"quit\" to exit TextExcel: ");
    		command = userInput.nextLine();
    	}
	}
}
