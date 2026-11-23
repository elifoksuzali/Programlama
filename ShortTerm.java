package bankaotomasyonu;
public class ShortTerm extends Account {
     Bank e2;
    public ShortTerm(){
        super();
    }
    public ShortTerm(int id,double amount){
        super(id,amount);
    }
    @Override
    public double deposit(double money){
       return getBalance()+ money;
    }
    @Override
    public double withdraw(double money1){
        if(getBalance()-money1<=1000){
            System.out.println("Limitiniz 1000 tl’ den az olamaz");
        }
        else{
            double balance=getBalance()-money1;
            return balance;
        }
        return 0;
    }
    @Override
    public double benefit(){
        return (e2.getDaysbetween()*0.17/365*getBalance()/100);
    }
    public String toString(){
        String k ="Kýsa vadeli hesap ve hesap bakiyesi:"+ getBalance()+"Kar miktarý"+benefit();
            return k;
    }
    }

