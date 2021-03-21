package com.cg.mts.entities;

public class BankAccount {
	public int accountno;
	public String accountHolderName;
	public String accountType;
	public BankAccount() {
		/* no implementation required */
	}
	public BankAccount(int accountno, String accountHolderName, String accountType) {
		super();
		this.accountno = accountno;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getAccountHolderNmae() {
		return accountHolderName;
	}
	public void setAccountHolderNmae(String accountHolderNmae) {
		this.accountHolderName = accountHolderNmae;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	

	

}
