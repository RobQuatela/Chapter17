package fileMatching;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class AccountRecord {
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	private Formatter output;
	
	//no argument constructor calls other constructor with default values
	public AccountRecord() {
		this(0, "", "", 0.0); //call 4 argument constructor
	}
	
	//initialize a record
	public AccountRecord(int acct, String first, String last, double bal) {
		setAccount(acct);
		setFirstName(first);
		setLastName(last);
		setBalance(bal);
	}
	
	//set-get methods for account
	public void setAccount(int acct) {
		account = acct;
	}
	public int getAccount() {
		return account;
	}
	
	//set-get methods for firstName
	public void setFirstName(String first) {
		firstName = first;
	}
	public String getFirstName() {
		return firstName;
	}
	
	//set-get methods for lastName
	public void setLastName(String last) {
		lastName = last;
	}
	public String getLastName() {
		return lastName;
	}
	
	//set-get methods for balance
	public void setBalance(double bal) {
		balance = bal;
	}
	public double getBalance() {
		return balance;
	}
	
	//method to change customer's balance
	public void combine(TransactionRecord trans, AccountRecord record) {
		//if the account numbers match from the AccountRecord and TransactionRecord objects
		if(record.getAccount() == trans.getAccountNumber()) {
			record.setBalance(record.getBalance() + trans.getTransaction());
		}
	}
	
	public boolean challenge(TransactionRecord trans, AccountRecord record) {
		//if the account numbers match from the AccountRecord and TransactionRecord objects
		if(record.getAccount() == trans.getAccountNumber()) {
			return true;
		}
		else
			return false;
	}
}
