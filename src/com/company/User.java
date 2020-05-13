package com.company;

import java.util.ArrayList;

public class User
{
    private String username;
    private String usersurname;
    private String customernumber;
    private String useremailaddress;
    private int password;
    private String usertelephonenumber;
    private ArrayList<Account> bankaccounts;
    private ArrayList<CreditCard> creditCards;
    //user's
    //name, surname, customer number, e-mail address, password, telephone number and bank
    //accounts (Account array)


    public User(String username, String usersurname, String customernumber, String useremailaddress, int password, String usertelephonenumber) {
        this.username = username;
        this.usersurname = usersurname;
        this.useremailaddress = useremailaddress;
        this.password = password;
        this.usertelephonenumber = usertelephonenumber;
        bankaccounts =new ArrayList<>();
        creditCards=new ArrayList<>();
        // müşteri numarasını kontrol ediliyor
        if(customernumber.trim().length()==8)
        {
            this.customernumber = customernumber;
        }else
            {
                System.out.println("müşteri numarası 8 haneli olmalı ");
            }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersurname() {
        return usersurname;
    }

    public void setUsersurname(String usersurname) {
        this.usersurname = usersurname;
    }

    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(String customernumber) {
        this.customernumber = customernumber;
    }

    public String getUseremailaddress() {
        return useremailaddress;
    }

    public void setUseremailaddress(String useremailaddress) {
        this.useremailaddress = useremailaddress;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getUsertelephonenumber() {
        return usertelephonenumber;
    }

    public void setUsertelephonenumber(String usertelephonenumber) {
        this.usertelephonenumber = usertelephonenumber;
    }
// en fazla 5 tane hesap olacağı denetleniyor
  public void addBankaccount(Account eklenecekhesap)
  {
      if(bankaccounts.size()<5)
      {
          bankaccounts.add(eklenecekhesap);
      }else
          {
              System.out.println("ekleybeileceğiniz hesap limitine ulaştınız");
          }

  }
  public void deleteBankaccount(Account silinecekhesap)
  {
      if(bankaccounts.size()>0)
      {
          bankaccounts.remove(silinecekhesap);
      }
      else
          {
              System.out.println("hesabınız yok");
          }

  }
  // en fazla 2 tane kredi kartı olacağı denetleniyor
  public void addCreditcar(CreditCard eklencekcreditCard)
  {
      if( creditCards.size()<2)
      {
         creditCards.add(eklencekcreditCard);
      }else
          {
              System.out.println("en fazla  2 tane kredi kartı ekleyebilirsiniz");
          }
  }
  public void showBankAccount()
  { int sayaç=1;
      for(Account account:bankaccounts)
      {
          System.out.println(sayaç+" "+account.toString());
          sayaç++;
      }
  }
    public void showCredicard()
    { int sayac=1;
        for(CreditCard creditCardtemp:creditCards)
        {
            System.out.println(sayac+" "+creditCardtemp.toString());
            sayac++;
        }
    }



}
