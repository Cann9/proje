package com.company;

import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private String customerNumber;
    private String email;
    private int password;
    private String telephone;
    private ArrayList<Account> bankAccounts;
    private ArrayList<CreditCard> creditCards;


    public User(String name, String surname, String customerNumber, String email, int password, String telephone) {
        this.name = name;
        this.surname = surname;
        this.customerNumber = customerNumber;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        bankAccounts = new ArrayList<>();
        creditCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public ArrayList<Account> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<Account> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(ArrayList<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    // en fazla 5 tane hesap olacağı denetleniyor
    public void addBankaccount(Account eklenecekhesap) {
        if (bankAccounts.size() < 5) {
            bankAccounts.add(eklenecekhesap);
        } else {
            System.out.println("ekleybeileceğiniz hesap limitine ulaştınız");
        }

    }

    public void deleteBankaccount(Account silinecekhesap) {
        if (bankAccounts.size() > 0) {
            bankAccounts.remove(silinecekhesap);
        } else {
            System.out.println("hesabınız yok");
        }

    }

    // en fazla 2 tane kredi kartı olacağı denetleniyor
    public void addCreditcar(CreditCard eklencekcreditCard) {
        if (creditCards.size() < 2) {
            creditCards.add(eklencekcreditCard);
        } else {
            System.out.println("en fazla  2 tane kredi kartı ekleyebilirsiniz");
        }
    }

    public void showBankAccount() {
        int sayaç = 1;
        for (Account account : bankAccounts) {
            System.out.println(sayaç + " " + account.toString());
            sayaç++;
        }
    }

    public void showCredicard() {
        int sayac = 1;
        for (CreditCard creditCardtemp : creditCards) {
            System.out.println(sayac + " " + creditCardtemp.toString());
            sayac++;
        }
    }

    // gelen indexe göre hesap döndürülüyor
    public Account getAccount(int index) {
        Account account = bankAccounts.get(index);
        return account;
    }


}
