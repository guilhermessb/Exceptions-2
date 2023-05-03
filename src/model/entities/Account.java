package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdraw) {
		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdraw;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdraw() {
		return withdrawLimit;
	}

	public void setWithdraw(Double withdraw) {
		this.withdrawLimit = withdraw;
	}

	public Double getBalance() {
		return balance;
	} 
	
	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) throws DomainException {
		
		if(amount > getWithdraw()) {
			throw new DomainException("Withdraw amount exceeds withdraw limit evaluable");
		}
		if(amount > getBalance()){
			throw new DomainException("Withdraw amount is higher than the balance evaluable");
		}
		else {
		this.balance -= amount;
		}
	}
	
}
