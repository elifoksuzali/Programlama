package bankaotomasyonu;
public class LongTerm extends Account {
    Bank e1;
    public LongTerm(){
        super();
    }
    public LongTerm(int id,double amount){
        super(id,amount);
    }
    @Override
    public double deposit(double money){
       return getBalance()+ money;
    }
    @Override
    public double withdraw(double money1){
        if(getBalance()-money1<=1500){
            System.out.println("Limitiniz 1500 tl’ den az olamaz");
        }
        else{
            double balance=getBalance()-money1;
            return balance;
        }
        return 0;
    }
    @Override
    public double benefit(){
        return (e1.getDaysbetween()*0.24/365*getBalance()/100);
    }
    public String toString(){
        String k ="Uzun vadeli hesap ve hesap bakiyesi:"+ getBalance()+"Kar miktarý"+benefit();
            return k;
    }	
    }
