package com.cg.project.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class BankAccount {
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	public long accountno;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	public String accountHolderName;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	public String accountType;
	
	public BankAccount() {
		
		/* no implementation required */
		
	}
	public BankAccount(long accountno, String accountHolderName, String accountType) {
		super();
		this.accountno = accountno;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}
	public long getAccountno() {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountHolderName == null) ? 0 : accountHolderName.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + (int) (accountno ^ (accountno >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (accountHolderName == null) {
			if (other.accountHolderName != null)
				return false;
		} else if (!accountHolderName.equals(other.accountHolderName))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (accountno != other.accountno)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BankAccount [accountno=" + accountno + ", accountHolderName=" + accountHolderName + ", accountType="
				+ accountType + "]";
	}	

	
}
