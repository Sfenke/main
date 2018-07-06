package javaapplication2;


public class Subscriber {
    private String surname;
    private int number;
    private double accountBalance;

    
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getSurname() {
        return surname;
    }

    public int getNumber() {
        return number;
    }

    public double getAccountBalance() {
        return accountBalance;
    }
    
    
    public Subscriber(String surname, int number, double accountBalance) {
        this.surname = surname;
        this.number = number;
        this.accountBalance = accountBalance;
        
    }

    @Override
    public String toString() {
        return "Фамилия: " + surname + ", Номер телефона: " + number + ", Баланс: " + accountBalance ;
    }
    
  
 }

