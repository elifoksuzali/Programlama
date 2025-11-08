package bankaotomasyonu;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BankaOtomasyonu {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int deger, id = 0;
        Bank bank = new Bank();
        Boolean condition1 = false; // do kısmının kontrol sartı
        int count;
        boolean condition = true; // do while while kısmını kotrol eden sart
        do {
            System.out.println(" Welcome to Bank.\n"
                    + "--------------------\n"
                    + "Lütfen yapacağınız işlemi seçiniz:\n"
                    + "İşlemler:\n"
                    + "---------------------\n"
                    + "-->Kısa vadeli hesap açmak için 1 tuşlayınız:\n"
                    + "-->Uzun vadeli hesap açmak için 2 tuşlayınız:\n"
                    + "-->Cari hesap açmak için 3 tuşlayınız:\n"
                    + "-->Para yatırmak için 4 tuşlayınız:\n"
                    + "-->Para çekmek için 5 tuşlayınız:\n"
                    + "-->Tüm hesapları listelemek için 6 tuşlayınız\n");
            deger = console.nextInt();
            boolean ayniMi;
            switch (deger) {
                case 1: {
                    do {
                        // herbiri için farklı aralık
                        ayniMi = false;

                        System.out.println("Hesap numaranızı giriniz:");
                        id = console.nextInt();
                        for (int i = 0; i < bank.accountList.size(); i++) {
                            if (bank.accountList.get(i).getId() == id) {
                                System.out.println("Aynı hesap mevcut.Yeniden giriş yapınız");
                                ayniMi = true;
                                break;
                            }
                        }
                    } while (ayniMi == true);

                    // eğer o hesap yok ise bakiye sordurmamayalım
                    System.out.println("Bakiye giriniz:");
                    double balance = console.nextDouble();
                    if (balance >= 1000) {
                        ShortTerm account = new ShortTerm(id, balance);
                        bank.accountList.add(account);
                        System.out.println(" Kısa vadeli hesabınız oluştulruldu.\n"
                                + " Hesap no " + id + " Hesap bakiyeniz " + balance);
                    } else {
                        System.out.println("Kısa vadeli hesap oluşturmak için bakiyeniz yeterli değil!\n");
                    }
                    break;
                }
                case 2: {
                    boolean ayniMi1 = false;
                    System.out.println(" Hesap numaranızı giriniz: ");
                    id = console.nextInt();
                    for (int i = 0; i < bank.accountList.size(); i++) {
                        if (bank.accountList.get(i).getId() == id) {
                            System.out.println("Aynı hesap mevcut.a");
                            ayniMi1 = true;
                            break;
                        }
                        while (true) {
                            System.out.println(" Bakiye giriniz: ");
                            double balance = console.nextDouble();
                            if (balance >= 1500) {
                                LongTerm account = new LongTerm(id, balance);
                                
                                bank.accountList.add(account);
                                System.out.println(" Uzun vadeli hesabınız oluştulruldu.\n"
                                        + " Hesap no " + id + " Hesap bakiyeniz " + balance);
                            } else {
                                System.out.println(" Uzun vadeli hesap oluşturmak için bakiyeniz yeterli değil!\n ");
                            }
                            break;
                        }
                    }
                }
                case 3: {
                    do {
                        ayniMi = false;
                        System.out.println(" Hesap numaranızı giriniz: ");
                        id = console.nextInt();
                        for (int i = 0; i < bank.accountList.size(); i++) {
                            if (bank.accountList.get(i).getId() == id) {
                                System.out.println("Aynı hesap mevcut.Yeniden giriş yapınız");
                                ayniMi = true;
                                break;
                            }
                        }
                    } while (ayniMi == true);
                    System.out.println(" Bakiye giriniz: ");
                    double balance = console.nextDouble();
                    Current account = new Current(id, balance);
                    bank.accountList.add(account);
                    System.out.println(" Cari  hesabınız oluştulruldu.\n"
                            + " Hesap no " + id + " Hesap bakiyeniz " + balance);
                }
                break;
                case 4: {
                    System.out.println(" Para yatırmak istediğiniz hesap numarasını giriniz:");
                    int a = console.nextInt();
                    System.out.println(" Para yatırmak istediğiniz miktarı giriniz:");
                    double money = console.nextDouble();
                    bank.deposit(a,money);
                    
                }
                break;
                                case 5: {
                    System.out.println(" Para çekmek istediğiniz hesap numarasını giriniz:");
                    int a = console.nextInt();
                    System.out.println(" Para çekmek istediğiniz miktarı giriniz:");
                    double money = console.nextDouble();
                    bank.withdraw(a, money);
                }
                break;
                // tüm hesapları listelemek için gereken kod for döngüsü tüm listeyi tarayarak o listeye kayıtlı id leri ekrana basacak.
                case 6: {
                    System.out.println("Tüm hesaplarını listesi:");
                    for (int i = 0; i < bank.accountList.size(); i++) {
                        System.out.println(bank.accountList.get(i).getId());
                    }
                }
                break;
                // son 5 işlem için gereken kod bloğu
   
                case 7: {
                }
                break;
               }
            System.out.print("İşlemi sonlandırmak için 0'a basınız. ");
            int islem = console.nextInt();
            if (islem == 0) {
                System.out.println(" işlem bitti. ");
                condition1 = false;
            }
        } while (condition == true);
    }
}
