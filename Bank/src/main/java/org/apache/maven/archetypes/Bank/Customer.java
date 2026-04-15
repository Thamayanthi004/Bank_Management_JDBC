package org.apache.maven.archetypes.Bank;
public class Customer {
    private int id;
    private String name;
    private String accountNumber;
    private double balance;

    public Customer() {}

    public Customer(int id, String name, String accountNumber, double balance) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ "]";
	}

    
}