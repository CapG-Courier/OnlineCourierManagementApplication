package com.cg.ocma.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class BankAccountEntity {
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	@Column(name = "accountno")
	public long accountNo;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	@Column(name = "accountholdername")
	public String accountHolderName;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	@Column(name = "accounttype")
	public String accountType;
	
	public BankAccountEntity() {
		
		/* no implementation required */
		
	}
	public BankAccountEntity(long accountNo, String accountHolderName, String accountType) {
		super();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}
	public long getAccountno() {
		return accountNo;
	}
	public void setAccountno(long accountNo) {
		this.accountNo = accountNo;
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

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", accountHolderName=" + accountHolderName + ", accountType="
				+ accountType + "]";
	}	

	
}
