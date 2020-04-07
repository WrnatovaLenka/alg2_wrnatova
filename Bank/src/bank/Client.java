package bank;

import java.util.ArrayList;

/**
 *
 * @author lenka.wrnatova
 */
public abstract class Client {
    //data
    private String name;
    private ArrayList<Account> accounts = new ArrayList();

    //konstruktor
    public Client(String name) {
        this.name = name;
    }

    //metody
    public String getName(){
        return name;
    }
    
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * prida klientovi novy ucet
     * @param amount 
     */
    public void addAccount(double amount) {
        accounts.add(new Account(amount));
    }
    
    /**
     * poskytne informaci o celkove sume penez na vsech uctech
     * @return 
     */
    public double showSumAccountBalance(){
        double sum = 0;
       for(Account account : accounts){
            sum += account.getAccountBalance();
        }
       return sum;
    }
    
    public abstract String displayNameOfClient();

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", accounts=" + accounts + '}';
    }
    
    
    
    
}
