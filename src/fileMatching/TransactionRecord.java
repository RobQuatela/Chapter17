package fileMatching;

public class TransactionRecord {

	private int accountNumber;
	private double transaction;
	
	//no arg construct
	public TransactionRecord() {
		
	}
	
	public TransactionRecord(int acct, double trans) {
		setAccountNumber(acct);
		setTransaction(trans);
	}
	
	//set-get methods
	public void setAccountNumber(int acct) {
		if(acct > 0)
			accountNumber = acct;
		else
			System.out.println("enter account number > 0");
	}
	
	public void setTransaction(double trans) {
		transaction = trans;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getTransaction() {
		return transaction;
	}
}
