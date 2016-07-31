package fileMatching;

import java.io.File;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CreateFiles {

	private Formatter output;
	private Scanner input;
	
	public CreateFiles() {
		
	}
	
	//open file
	public void openOldMastFile() {
		try {
			output = new Formatter("oldmast.txt");
			System.out.println("oldmast.txt is open");
		}
		catch(FileNotFoundException e) {
			System.err.println("file not found");
		}
	}
	
	//open trans file
	public void openTransFile() {
		try {
			output = new Formatter("trans.txt");
			System.out.println("trans.txt is open");
		}
		catch(FileNotFoundException e) {
			System.err.println("file not created");
		}
	}
	
	//write to oldmast file
	public void writeOldMastFile() {
		input = new Scanner(System.in);
		AccountRecord record = new AccountRecord();
		
		System.out.print("Enter in customer account, first, last, and balance: ");
		
		while(input.hasNext()) {
			record.setAccount(input.nextInt());
			record.setFirstName(input.next());
			record.setLastName(input.next());
			record.setBalance(input.nextDouble()); 
			
			output.format("%d %s %s %.2f\n", record.getAccount(),
					record.getFirstName(), record.getLastName(),
					record.getBalance());
			System.out.println();
			System.out.print("Enter in customer account, first, last, and balance: ");
		}
		

	}
	
	//write to trans file
	public void writeTransFile() {
		input = new Scanner(System.in);
		TransactionRecord record = new TransactionRecord();

		System.out.print("Enter transaction account and transaction amount: ");
		
		while(input.hasNext()) {
			record.setAccountNumber(input.nextInt());
			record.setTransaction(input.nextDouble());
			
			output.format("%d %.2f\n", record.getAccountNumber(), record.getTransaction());
			System.out.println();
			System.out.print("Enter transaction account and transaction amount: ");
		}
	}
	
	//close file
	public void closeFile() {
		if(output != null) {
			output.close();
			System.out.println("File closed...");
		}
	}
}
