package chapterExcercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReatTextFile {

	private Scanner input;
	
	//enables user to open file
	public void openFile() {
		try {
			input = new Scanner(new File("clients.txt"));
		}
		catch(FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file");
			System.exit(1);
		}
	}
	
	//read record from file
	public void readRecords() {
		//object to be written to screen
		AccountRecord record = new AccountRecord();
		
		System.out.printf("%-10s%-12s%-12s%10s\n", "Account",
				"First Name", "Last Name", "Balance");
		
		try { //read records from file using scanner object
			while(input.hasNext()) {
				record.setAccount(input.nextInt());
				record.setFirstName(input.next());
				record.setLastName(input.next());
				record.setBalance(input.nextDouble());
				
				//display record contents
				System.out.printf("%-10d%-12s%-12s%10.2f\n", 
						record.getAccount(), record.getFirstName(),
						record.getLastName(), record.getBalance());
			}
		}
		catch(NoSuchElementException noSuchElementException) {
			System.err.println("File improperly formed");
			input.close();
			System.exit(1);
		}
		catch(IllegalStateException stateException) {
			System.err.println("Error reading from file.");
			System.exit(1);
		}
	}
	
	//close file and terminate
	public void closeFile() {
		if(input != null) 
			input.close();
	}
}
