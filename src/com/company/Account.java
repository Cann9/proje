package com.company;

public class Account
{
    private int balance;
    private int minimumbalancelimit;
    private int accountnumber;
    private String ibannumber;

    public Account(int balance, int accountnumber, String ibannumber) {
        this.balance = balance;
        this.minimumbalancelimit =1000;
        this.accountnumber = accountnumber;
        this.ibannumber = ibannumber;
    }
    public boolean eftTransaction(Account otheraccount, int mount)
    { // balancecheck metodu bakiyenin minimum bakiyeden büyük mü ona bakıyor
        if(balanceCheck() && balance>=mount)
        {//eft yapılacak hesabın bakiyesi alınıyor
            int otheraccountbalance=otheraccount.getBalance();
            // para mşktarı giden hesabın bakiyesine ekleniyor
            otheraccountbalance+=mount;
            this.balance-=mount;
            // gönderininkinden de düşüyor
            otheraccount.setBalance(otheraccountbalance);
            return true;
        }else
            {
                System.out.println(" işlem başarısız lütfen bakiyenizi kontrol ediniz... ");
                return false;
            }
    }
   private boolean balanceCheck()
    {
        if(balance>0 && balance>=minimumbalancelimit)
        {
            return true;
        }else
            {
                return false;
            }
    }
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMinimumbalancelimit() {
        return minimumbalancelimit;
    }

    public void setMinimumbalancelimit(int minimumbalancelimit) {
        this.minimumbalancelimit = minimumbalancelimit;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getIbannumber() {
        return ibannumber;
    }

    public void setIbannumber(String ibannumber) {
        this.ibannumber = ibannumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", minimumbalancelimit=" + minimumbalancelimit +
                ", accountnumber=" + accountnumber +
                ", ibannumber='" + ibannumber + '\'' +
                '}';
    }
}
