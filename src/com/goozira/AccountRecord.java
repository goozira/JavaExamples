package com.goozira;

//  AccountRecord class maintains information for one account.
public class AccountRecord
{

    private int account;
    private String firstName;
    private String lastName;
    private double balance;

    //  no-argument constructor calls other constructor with default values
    public AccountRecord()
    {
        this(0, "", "", 0.0);  //  call four-argument constructor
    }

    //  initialize a record
    public AccountRecord(int acct, String first, String last, double bal)
    {
        setAccount(acct);
        setFirstName(first);
        setLastName(last);
        setBalance(bal);
    }

    public int getAccount() {
        return account;
    }

    private void setAccount(int account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

}
