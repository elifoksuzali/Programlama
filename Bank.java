package bankaotomasyonu;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
public class Bank {
    public ArrayList<Account> accountList = new ArrayList<Account>();
    private LocalDate firstDate=LocalDate.of(2019,01,01);
    private LocalDate secondDate=LocalDate.now();
    public long getDaysbetween(){
    long daysbetween=DAYS.between(firstDate,secondDate);
        return daysbetween;

    }
    // para cekme işlemi için gereken kod satırı
    public void withdraw(int id, double money1){
        for (int i = 0; i<accountList.size(); i++) {
            if (accountList.get(i).getId() == id) {
                accountList.get(i).withdraw(money1);
                System.out.println(id + " Hesaptan para çekildi " +money1);
            }
            else{
                System.out.println("Böyle bir hesap numarası yok.");
            }
        }      
    }
    // para yatırma işleminin yapılması için gereken kod  satırı
    public void  deposit(int id,double money){
        for (int i = 0; i<accountList.size(); i++) {
            if (accountList.get(i).getId() == id) {
                accountList.get(i).deposit(money);
                System.out.println(id + " Hesaba para yatırıldı " +money );
            }            
            else{
                System.out.println(" Böyle bir hesap numarası yok. ");
            }
        }
    }
    // mevcut hesapların listesini için kod bloğu
   public void getAccount(){
       for(int i=0; i<accountList.size(); i++){
           System.out.println( i+"  . ve   " +  accountList.get(i).toString());
       }   
   }
}    
