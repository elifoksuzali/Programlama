package bankaotomasyonu;
public class Current extends Account {
    public Current(){
        super();
    }
    public Current(int id,double amount){
        super(id,amount);
    }
    @Override
    public double deposit(double money){
       double balance=getBalance()+money;
       return getBalance;
    }
    @Override
    public double withdraw(double money1){
        double balance=getBalance()-money1;
        return balance;
    }
    @Override
    public double benefit(){
        return 0;
    }
    public String toString(){
        String k ="Cari hesap ve hesabýn bakiyesi:"+ getBalance()+"Kar miktarý"+benefit();
            return k;
    }
    }
