package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<User> user=new ArrayList<>();
    static ArrayList<Account> accounts=new ArrayList<>();
    static Account girilenhesap=null;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        boolean onlinebankinstart=true;
        boolean anamenüyedönmek=true;


        User us1=new User("can","ilhan","12345678","canilhn1@gmail.com",123456,"054343443459");
        User us2=new User("mert","çavdar","12345578","canilhn1@gmail.com",122456,"05214054559");
        user.add(us1);
        user.add(us2);
        createAccount();
        us1.addBankaccount(accounts.get(0));
        us1.addBankaccount(accounts.get(1));
        us1.addBankaccount(accounts.get(2));
        us1.addBankaccount(accounts.get(3));

        CreditCard card1= new CreditCard(6000,"3456781231",2345);
        CreditCard card2= new CreditCard(6000,"3456781231",2345);
        CreditCard card3= new CreditCard(6000,"3456781231",2345);
        CreditCard card4= new CreditCard(6000,"3456781231",2345);
        CreditCard card5= new CreditCard(6000,"3456781231",2345);

        us1.addCreditcar(card1);
        us1.addCreditcar(card2);

        us2.addBankaccount(accounts.get(4));
        us2.addCreditcar(card3);
        us2.addCreditcar(card4);



        while(onlinebankinstart)
        {
            System.out.println("ltfen giriş yapınız");
            System.out.println("lütfen müşteri numarınızı giriniz");
            String customernumber=input.next();
            System.out.println("parolanızı giriniz");
            int password=input.nextInt();
            //müşteri numarası ve şifreye göre kullanıcıyı alıp geçici bir kulalnıcı nesnesine atadım
            User girenkullanıcı = users(customernumber,password);
            if(girenkullanıcı!=null)
            {   // şifre ve müşteri numarası doğru mu o kontrol ediliyor
                if(customernumber.matches(girenkullanıcı.getCustomernumber()) && password==girenkullanıcı.getPassword() )
                {
                    System.out.println("giriş başarılı");
                    System.out.println("giren kullanıcın ismi"+girenkullanıcı.getUsername());
                    System.out.println("");
                    //burdan sonra kullanıcı isterse tekrar ' eft yapmak için 1'e kredi kartı borcunuzu ödemek için 2 ye basınız ' kısmına dönebilsin diye while içine aldım
                    while (anamenüyedönmek){
                        System.out.println("eft yapmak için 1'e kredi kartı borcunuzu ödemek için 2 ye basınız");
                        int kullanıcıseçim=input.nextInt();
                        if(kullanıcıseçim==2)
                        {//kullanıcının sahip olduğu kredi kartları gösteriliyor    projenin bundan sonrası eksik  burdan devam edicem
                           girenkullanıcı.showCredicard();
                        } else if (kullanıcıseçim==1)
                        { // eft yapmak isteyen kullanıcı geldi
                            System.out.println(" hesaplara gitmek için başlarındaki sayılara basınız");
                            // hesapları  gösteriliyor
                            girenkullanıcı.showBankAccount();
                            int gelenhesap=input.nextInt();
                            switch (gelenhesap)
                            {
                                case 1:
                                    efttransactionaccount(girenkullanıcı,0);
                                    //kullanıcı çıkmak isterse
                                    System.out.println("çıkmak için 1 e basınız ana menüye dönmek için 2'ye basınız");
                                    int çıkış=input.nextInt();
                                    if(çıkış==1)
                                    {
                                        System.exit(0);
                                    }else if (çıkış==2){
                                        break;
                                    }

                                    case 2:
                                    efttransactionaccount(girenkullanıcı,1);
                                    System.out.println("çıkmak için 1 e basınız ana menüye dönmek için 2'ye basınız");
                                    int çıkış2=input.nextInt();
                                    if(çıkış2==1)
                                    {
                                        System.exit(0);
                                    }else if (çıkış2==2){
                                        break;
                                    }

                                    break;
                                case 3:
                                    efttransactionaccount(girenkullanıcı,2);
                                    System.out.println("çıkmak için 1 e basınız ana menüye dönmek için 2'ye basınız");
                                    int çıkış3=input.nextInt();
                                    if(çıkış3==1)
                                    {
                                        System.exit(0);
                                    }else if (çıkış3==2){
                                        break;
                                    }
                                case 4:
                                    efttransactionaccount(girenkullanıcı,3);
                                    System.out.println("çıkmak için 1 e basınız ana menüye dönmek için 2'ye basınız");
                                    int çıkış4=input.nextInt();
                                    if(çıkış4==1)
                                    {
                                        System.exit(0);
                                    }else if (çıkış4==2){
                                        break;
                                    }
                                case  5:
                                    efttransactionaccount(girenkullanıcı,4);
                                    System.out.println("çıkmak için 1 e basınız ana menüye dönmek için 2'ye basınız");
                                    int çıkış5=input.nextInt();
                                    if(çıkış5==1)
                                    {
                                        System.exit(0);
                                    }else if (çıkış5==2){
                                        break;
                                    }
                                default:
                                    break;
                            }
                        }
                        else
                        {
                            System.out.println("geçerli bir seçim yapınız");
                        }
                    }

                }else
                {
                    System.out.println("lütfen müşteri numaranızı ya da parolanızı kontrol ediniz");
                    continue;
                }
            }else
                {
                    System.out.println("kullanıcı bulunamadı");
                    continue;
                }
        }

    }
    // hesaplar yaratıldı bu metotda  ve hesap listesine atılıyor
    public static   void createAccount()
    {
        Account ac1=new Account(243423,123456,"tr213234213731");
        Account ac2=new Account(2345,1234562,"tr213234213631");
        Account ac3=new Account(34656,1234563,"tr213234213151");
        Account ac4=new Account(4568,1234564,"tr213234213132");
        Account ac5=new Account(45682323,1212232,"tr21323421322132");
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);
        accounts.add(ac5);
    }
    // girilen müşterinumarası ve şifreye göre kullanıcı var mı onu kontrol ediliyor uygunnvarsa giriş yapabiliyor
    public static User users(String müşterinum,int şifre)
    {User temp=null;
        for(int i=0;i<user.size();i++)
        {
            if(müşterinum.matches(user.get(i).getCustomernumber()) && şifre==user.get(i).getPassword())
            {
                 temp= user.get(i);
            }
        }

        return temp;
    }
    //eft için diğer hesabı alıyorum girilen  ibannumarasına göre
    public static Account anotheraccount(String ibannummber)
    {
        Account tempaccount=null;
        for(int i=0;i<accounts.size();i++)
        {
            if(ibannummber.matches(accounts.get(i).getIbannumber()))
            {
                tempaccount=accounts.get(i);
            }

        }
        return tempaccount;
    }
    //
    public static void efttransactionaccount( User girenkullanıcı,int index)
    {
        Scanner input=new Scanner(System.in);
        //getaccount metodu User sınıfın içinde arraylistte verilenm index e göre hesabı
        girilenhesap=girenkullanıcı.getAccount(index);
        System.out.println("eft yapacağınız hesabın ibannumarasını giriniz...");
        // burda ibanı da kontrol etmem lazım fakat dah orayı yapmadım...
        String diğerhesabınibanı=input.next();
        //anotheraccount metoduyla iban numarası girilen hesabı almıştım onu geçici bir hesap nesnesine atadım
        Account paranınyatırılacağıhesap= anotheraccount(diğerhesabınibanı);
        System.out.println("para miktarını giriniz");
        int yatırılacakparamiktarı=input.nextInt();
        if(girilenhesap.eftTransaction(paranınyatırılacağıhesap,yatırılacakparamiktarı))
        {
            System.out.println(" işlem başarılı ");
        }
        //BU METODU CASELERİN ALTINDAKİ KODLARI AZALTMAK VE TEKRAR TEKRAR YAZMAMK İÇİN YAZDIM   BU METODUN TEK AMACI CASELERİN ALTINDA KULLANILMAK...

    }
}
