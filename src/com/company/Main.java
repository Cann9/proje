package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        boolean onlinebankinstart=true;
        User us1=new User("can","ilhan","12345678","canilhn1@gmail.com",123456,"05434057459");
        Account ac1=new Account(243423,123456,"tr213234213731");
        Account ac2=new Account(2345,1234562,"tr213234213631");
        Account ac3=new Account(34656,1234563,"tr213234213151");
        Account ac4=new Account(4568,1234564,"tr213234213132");


        CreditCard card1= new CreditCard(6000,"3456781231",2345);
        CreditCard card2= new CreditCard(6000,"3456781231",2345);
        CreditCard card3= new CreditCard(6000,"3456781231",2345);
        CreditCard card4= new CreditCard(6000,"3456781231",2345);
        CreditCard card5= new CreditCard(6000,"3456781231",2345);
        us1.addBankaccount(ac1);
        us1.addBankaccount(ac2);
        us1.addBankaccount(ac3);
        us1.addBankaccount(ac4);
        us1.addBankaccount(ac4);

        us1.addCreditcar(card1);
        us1.addCreditcar(card2);
        while(onlinebankinstart)
        {
            System.out.println("ltfen giriş yapınız");
            System.out.println("lütfen müşteri numarınızı giriniz");
            String customernumber=input.next();
            System.out.println("parolanızı giriniz");
            int password=input.nextInt();
            if(customernumber.matches(us1.getCustomernumber()) && password== us1.getPassword() )
            {
                System.out.println("giriş başarılı");
                System.out.println("");
                System.out.println("eft yapmak için 1'e kredi kartı borcunuzu ödemek için 2 ye basınız");
                int kullanıcıseçim=input.nextInt();
                if(kullanıcıseçim==2)
                {
                    System.out.println("*  ");
                } else if (kullanıcıseçim==1)
                {
                    System.out.println(" hesaplara gitmek için başlarındaki sayılara basınız");
                    us1.showBankAccount();
                    int gelenhesap=input.nextInt();
                    switch (gelenhesap)
                    {
                        case 1:

                            break;
                        case 2:
                                break;
                        case 3:
                            break;
                        default:
                            break;
                    }
                }
            }else
                {
                    System.out.println("lütfen müşteri numaranızı ya da parolanızı kontrol ediniz");
                    continue;
                }
        }

    }
}
