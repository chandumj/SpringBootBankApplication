package com.sathyabank.model;

public class Transfer {
	private long accno;
	private String name;
	private String password;
	private long targetAccno;
	private double amount;
	public Transfer() {
		super();
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getTargetAccno() {
		return targetAccno;
	}
	public void setTargetAccno(long targetAccno) {
		this.targetAccno = targetAccno;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
