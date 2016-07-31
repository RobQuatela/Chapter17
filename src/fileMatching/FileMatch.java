package fileMatching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileMatch {

	private Scanner input;
	private Formatter output;
	private Formatter outputLog;
	
	//open accountRecord
	public void openOldMastFile() {
		try {
			input = new Scanner(new File("oldmast.txt"));
		}
		catch(FileNotFoundException e) {
			System.err.println("File not found");
			System.exit(1);
		}
	}
	
	//read OldMast file
	public void matchFiles() {
		AccountRecord record = new AccountRecord();
		TransactionRecord trans = new TransactionRecord();
		
		//create newmast.txt file to write changes from oldmast.txt
		try {
			output = new Formatter("newmast.txt");
		}
		catch(FileNotFoundException e) {
			System.err.println("No newmast.txt found");
		}
		
		//create log file 
		try {
			outputLog = new Formatter("log.txt");
		}
		catch(FileNotFoundException e) {
			System.err.println("error creating log.txt");
		}
		
		
		try {
			while(input.hasNext()) {
				record.setAccount(input.nextInt());
				record.setFirstName(input.next());
				record.setLastName(input.next());
				record.setBalance(input.nextDouble());
				
				//re-open transfile to match in each iteration of loop
				try {
					//created local scanner to reset when loop iterates
					Scanner transInput = new Scanner(new File("trans.txt"));
					while(transInput.hasNext()) {
						trans.setAccountNumber(transInput.nextInt());
						trans.setTransaction(transInput.nextDouble());
						
						//try to add transaction to customer balance
						if(record.challenge(trans, record))
							record.combine(trans, record);
						else {
							//write to the log.txt file if unmatched account numbers
							outputLog.format("%s %d\n", "Unmatched transaction record for account number ",
									trans.getAccountNumber());
						}
					}
				}
				catch(FileNotFoundException e) {
					System.err.println("this didn't work dumbass");
				}
				
				//write the new information to the newmast.txt file
				output.format("%d %s %s %.2f\n", record.getAccount(),
						record.getFirstName(), record.getLastName(), record.getBalance());
			}
			//close formatter to save written streams
			output.close();
			outputLog.close();
		}
		catch(NoSuchElementException e) {
			System.err.println("no elements in this doc");
		}
		catch(IllegalStateException e) {
			System.err.println("errors reading file");
		}
	}
	
	//close file
	public void closeFile() {
		if(input != null)
			input.close();
	}
}
