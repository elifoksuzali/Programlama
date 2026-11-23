package bankaotomasyonu;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;	
public abstract class Account {
    private int id;
    private double balance;
    protected Account(){
      id=0;
      balance=0.0;
    }
    protected Account(int id,double amount){
      this.id=id;
      balance=amount;
    }
    public void setBalance(double amount){
        balance=amount;
    }
    public void setId(int id){
        this.id=id;
    }
    public double getBalance(){
        return balance;
    }
    public int getId(){
        return id;
    }
// Abstract methodlar
    public abstract double deposit(double money);
    public abstract double withdraw(double money1);
    public abstract double benefit();
}
