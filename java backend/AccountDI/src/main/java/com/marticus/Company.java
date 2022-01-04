package com.marticus;

public class Company {

	private Account acc;

	public Account getacc() {
		return acc;
	}

	public void setacc(Account acc) {
		this.acc = acc;
	}
	
 public void showAcc()
 {
	
	 acc.showaccType();
	 
 }

}
