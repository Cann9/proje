package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Account> accounts = new ArrayList<>();
    static ArrayList<CreditCard> cards = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        createDefaultUsersAccountsAndCards();

        while (true) {
            System.out.println("lütfen müşteri numarınızı giriniz veya uygulamadan çıkış için 0 a basınız");
            String customerNumber = input.next();
            if (customerNumber.equals("0")) {
                System.exit(-1);
            }
            System.out.println("parolanızı giriniz");
            int password = input.nextInt();
            //müşteri numarası ve şifreye göre kullanıcıyı alıp geçici bir kulalnıcı nesnesine atadım
            User user = findUserByCustomerNumber(customerNumber, password);
            if (user != null) {

                System.out.println("giriş başarılı");
                System.out.println("giren kullanıcın ismi " + user.getName() + " " + user.getSurname());
                System.out.println("");
                //burdan sonra kullanıcı isterse tekrar ' eft yapmak için 1'e kredi kartı borcunuzu ödemek için 2 ye basınız ' kısmına dönebilsin diye while içine aldım
                while (true) {
                    System.out.println("eft yapmak için 1'e\r\nkredi kartı borcunuzu ödemek için 2'ye\r\nYeni Hesap Açılışı için 3'e\r\nYeni Kredi Kartı tanımlamak için 4'e basınız");
                    System.out.println("kullanıcı çıkışı için 0 a basınız");

                    int selectedInput = input.nextInt();
                    if (selectedInput == 0) {
                        break;
                    } else if (selectedInput == 4) {
                        addCardToUser(user,1000,0);
                        user.showCredicard();
                    } else if (selectedInput == 3) {
                        addAccountToUser(user,0);
                        user.showBankAccount();
                    } else if (selectedInput == 2) {
                        //kullanıcının sahip olduğu kredi kartları gösteriliyor    projenin bundan sonrası eksik  burdan devam edicem
                        user.showCredicard();
                    } else if (selectedInput == 1) { // eft yapmak isteyen kullanıcı geldi
                        System.out.println(" hesaplara gitmek için başlarındaki sayılara basınız");
                        // hesapları  gösteriliyor
                        user.showBankAccount();
                        int gelenhesap = input.nextInt();
                        Account selectedAccount;
                        try {
                            //getaccount metodu User sınıfın içinde arraylistte verilenm index e göre hesabı
                            selectedAccount = user.getAccount(gelenhesap - 1);
                        } catch (Exception e) {
                            // Array indexleri dışında bir seçim yapılırsa burada yakalanıp müşteri uyarılır
                            System.out.println("Hatalı seçim yaptınız");
                            continue;
                        }

                        System.out.println("eft yapacağınız hesabın ibannumarasını giriniz...");
                        String IBAN = input.next();

                        // burda ibanı da kontrol etmem lazım fakat dah orayı yapmadım...
                        //findAccountByIBAN metoduyla iban numarası girilen hesabı almıştım onu geçici bir hesap nesnesine atadım
                        Account toAccount = findAccountByIBAN(IBAN);

                        if (toAccount == null) {
                            System.out.println("Hatalı IBAN");
                            continue;
                        }

                        System.out.println("para miktarını giriniz");
                        int money = input.nextInt();
                        if (selectedAccount.eftTransaction(toAccount, money)) {
                            System.out.println(" işlem başarılı ");
                            user.showBankAccount();
                        } else {
                            continue;
                        }

                    } else {
                        System.out.println("geçerli bir seçim yapınız");
                    }
                }

            } else {
                System.out.println("kullanıcı bulunamadı");
                continue;
            }
        }

    }

    public static void createDefaultUsersAccountsAndCards() {
        User user1 = new User("can", "ilhan", "12345678", "canilhn1@gmail.com", 123456, "054343443459");
        User user2 = new User("mert", "çavdar", "4321", "mertcan@gmail.com", 1234, "05214054559");
        users.add(user1);
        users.add(user2);

        addAccountToUser(user1, 1000);
        addCardToUser(user1, 2000, 500);

        addAccountToUser(user2, 2000);
        addCardToUser(user1, 4000, 200);

    }

    public static void addAccountToUser(User user, int initialBalance) {
        Account account = new Account(initialBalance, accounts.size() + 1, "TR200000120002000000110102" + accounts.size());
        user.addBankaccount(account);
        accounts.add(account);
    }

    public static void addCardToUser(User user, int cardLimit, int depth) {
        CreditCard card = new CreditCard(cardLimit, "2000300040005000100" + cards.size(), depth);
        user.addCreditcar(card);
        cards.add(card);
    }

    // girilen müşterinumarası ve şifreye göre kullanıcı var mı onu kontrol ediliyor uygunnvarsa giriş yapabiliyor
    public static User findUserByCustomerNumber(String customerNumber, int password) {
        User temp = null;
        for (int i = 0; i < users.size(); i++) {
            if (customerNumber.equals(users.get(i).getCustomerNumber()) && password == users.get(i).getPassword()) {
                temp = users.get(i);
            }
        }

        return temp;
    }

    //eft için diğer hesabı alıyorum girilen  ibannumarasına göre
    public static Account findAccountByIBAN(String IBAN) {
        Account tempaccount = null;
        for (int i = 0; i < accounts.size(); i++) {
            if (IBAN.equals(accounts.get(i).getIbannumber())) {
                tempaccount = accounts.get(i);
            }
        }
        return tempaccount;
    }


}
